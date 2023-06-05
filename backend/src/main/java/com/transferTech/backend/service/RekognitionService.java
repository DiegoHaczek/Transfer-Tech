package com.transferTech.backend.service;


import com.amazonaws.services.rekognition.AmazonRekognition;
import com.amazonaws.services.rekognition.AmazonRekognitionAsyncClientBuilder;
import com.amazonaws.services.rekognition.model.*;
import com.transferTech.backend.dto.auth.ApprovalRequestDto;
import com.transferTech.backend.exception.RejectedRequest;
import com.transferTech.backend.dto.MessageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@EnableAsync
@RequiredArgsConstructor
public class RekognitionService {

    private final AmazonRekognition rekognitionClient = AmazonRekognitionAsyncClientBuilder
            .standard().withRegion("us-east-1").build();
    private final Logger logger = Logger.getLogger(RekognitionService.class.getName());

    //@Async
    public MessageResponse verifyIdentity(ApprovalRequestDto request) throws IOException {
        logger.log(Level.INFO,"Verificando credenciales");

        Image image = new Image().withBytes(ByteBuffer.wrap(request.getSelfie_photo().getBytes()));
        Image frontIdCard = new Image().withBytes(ByteBuffer.wrap(request.getIdentity_card_front().getBytes()));
        Image backIdCard = new Image().withBytes(ByteBuffer.wrap(request.getIdentity_card_back().getBytes()));


        if(imagesAreIdentityCard(frontIdCard,backIdCard)){
            if(imagesAreFromTheSameIdentityCard(frontIdCard,backIdCard)){
                if (selfieMatchIdentityCardOwner(image, frontIdCard)){
                    return new MessageResponse
                            (400, "The provided documentation is valid");
                }
            }
        }
        return new MessageResponse
                (406, "The provided documentation isn't valid");
    }
    public boolean imagesAreIdentityCard(Image idFront, Image idBack){
        logger.log(Level.INFO,"Verificando validez de la documentacion");
        DetectLabelsRequest idLabelRequest = new DetectLabelsRequest()
                .withMaxLabels(7);
        DetectLabelsResult frontCardLabelResult = rekognitionClient.detectLabels(
                idLabelRequest.withImage(idFront));
        DetectLabelsResult backCardLabelResult = rekognitionClient.detectLabels(
                idLabelRequest.withImage(idBack));
        float cardFrontConfidence = getIdCardLabelConfidence(frontCardLabelResult);
        //System.out.println("Card Front Confidence: " + cardFrontConfidence);

        float cardBackConfidence = getIdCardLabelConfidence(backCardLabelResult);
        //System.out.println("Card Back Confidence: " + cardBackConfidence);

        if (cardFrontConfidence > 85 && cardBackConfidence > 85){
            logger.log(Level.INFO,"Documentación Válida");
            return true;
        }
        logger.log(Level.INFO,"Documentación No Válida");
        throw new RejectedRequest("Documentación No Válida");
    }
    private static Float getIdCardLabelConfidence(DetectLabelsResult frontCardLabelResult) {
        return frontCardLabelResult.getLabels()
                .stream()
                .filter(e -> e.getName().equals("Id Cards"))
                .findFirst()
                .map(Label::getConfidence)
                .stream().reduce(0F, Float::sum);
    }
    public Map<String,List<String>> extractFrontCardCredentials(Image idFront){
        RegionOfInterest completeNameRegion = new RegionOfInterest().withBoundingBox(
                new BoundingBox().withWidth(0.24F).withHeight(0.22F).withLeft(0.33F).withTop(0.22F)
        );
        RegionOfInterest idNumberRegion = new RegionOfInterest().withBoundingBox(
                new BoundingBox().withWidth(0.2F).withHeight(0.17F).withLeft(0.1F).withTop(0.8F)
        );
        DetectTextFilters textFilters = new DetectTextFilters()
                .withRegionsOfInterest(completeNameRegion,idNumberRegion);
        DetectTextRequest textRequest = new DetectTextRequest()
                .withImage(idFront)
                .withFilters(textFilters);
        List<TextDetection> textDetections = rekognitionClient.detectText(textRequest).getTextDetections();
        //textDetections.forEach(System.out::println);
        if(textDetections.isEmpty()){
            logger.log(Level.WARNING,"Error en la extracción de información del frontal del documento");
            throw new RejectedRequest("Error en la extracción de información del frontal del documento, la imagen no está bien recortada");
        }
        Map<String, List<String>> frontCardCredentials = getFrontCredentialsFromTextDetections(textDetections);
        //System.out.println(frontCardCredentials);
        logger.log(Level.INFO,"Extracción de la información frontal exitosa");
        return frontCardCredentials;
    }
    private static Map<String, List<String>> getFrontCredentialsFromTextDetections(List<TextDetection> textDetections) {
        Pattern isDniRegex = Pattern.compile("^\\d{1,3}\\./?\\d{3}\\./?\\d{3}$");
        Pattern isNameRegex = Pattern.compile("[A-ZÁÉÍÓÚ]+");
        Function<String,String> dniOrName = e -> e.matches(isNameRegex.toString())? "Name" : "Dni";
        Function<String,String> removeDotsFromDni = e -> e.contains(".")? e.replace(".","") : e;

        return textDetections.stream()
                .map(TextDetection::getDetectedText)
                .distinct()
                .filter(isDniRegex.asPredicate().or(isNameRegex.asMatchPredicate()))
                .map(removeDotsFromDni)
                .collect(Collectors.groupingBy(dniOrName));
    }
    public Map<String,List<String>> extractBackCardCredentials(Image idBack){

        RegionOfInterest nameAndDniRegion = new RegionOfInterest().withBoundingBox(
                new BoundingBox().withWidth(0.6F).withHeight(0.3F).withLeft(0.02F).withTop(0.7F)
        );
        DetectTextFilters textFilters = new DetectTextFilters()
                .withRegionsOfInterest(nameAndDniRegion);
        DetectTextRequest textRequest = new DetectTextRequest()
                .withImage(idBack)
                .withFilters(textFilters);
        List<TextDetection> textDetections = rekognitionClient.detectText(textRequest).getTextDetections();
        //textDetections.forEach(System.out::println);
        if(textDetections.isEmpty()){
            logger.log(Level.WARNING,"Error en la extracción de información del dorso del documento");
            throw new RejectedRequest("Error en la extracción de información del dorso del documento," +
                    " la imagen no está bien recortada");
        }

        Map<String, List<String>> backCardCredentials = getBackCredentialsFromTextDetections(textDetections);

        logger.log(Level.INFO,"Extracción de la información dorsal exitosa");
        return backCardCredentials;
    }
    private static Map<String, List<String>> getBackCredentialsFromTextDetections(List<TextDetection> textDetections) {
        Pattern isDniRegex = Pattern.compile("^IDARG.*");
        Pattern isNameRegex = Pattern.compile("^[A-Z]{2,13}+<.*");
        Function<String,String> dniOrName = e -> e.matches(isNameRegex.toString())? "Name" : "Dni";
        Function<String,String> removeSignatureFromDni = e -> e.startsWith("IDARG") ? e.substring(5, 13) : e;

        Map<String,List<String>> backCardCredentials = textDetections.stream()
                .map(TextDetection::getDetectedText)
                .distinct()
                .filter(isDniRegex.asPredicate().or(isNameRegex.asMatchPredicate()))
                .map(removeSignatureFromDni)
                .collect(Collectors.groupingBy(dniOrName));

        // System.out.println(backCardCredentials);

        if(!backCardCredentials.containsKey("Name")){
            throw new RejectedRequest("Error en la extracción de información del dorso del documento," +
                    " la imagen no está bien recortada");
        }

        backCardCredentials.replace("Name",List.of(backCardCredentials.get("Name").get(0).split("<{1,2}")));
        //System.out.println(backCardCredentials);
        return backCardCredentials;
    }
    public boolean imagesAreFromTheSameIdentityCard(Image idFront, Image idBack) {
        logger.log(Level.INFO,"Comparando información de ambos lados de la documentación");
        Map<String,List<String>> frontCardInfo = extractFrontCardCredentials(idFront);
        Map<String,List<String>> backCardInfo = extractBackCardCredentials(idBack);

        if(frontCardInfo.get("Dni").equals(backCardInfo.get("Dni"))
                && frontCardInfo.get("Name").equals(backCardInfo.get("Name"))){
            logger.log(Level.INFO,"Las dos imágenes pertenecen a un mismo documento");
            return true;
        }else {
            logger.log(Level.INFO,"Las dos imágenes no pertenecen a un mismo documento");
            throw new RejectedRequest("Las dos imágenes no pertenecen a un mismo documento");
        }
    }
    public boolean selfieMatchIdentityCardOwner(Image idFront, Image selfie) {
        logger.log(Level.INFO,"Verificando que la documentación pertenece al usuario");
        CompareFacesRequest request = new CompareFacesRequest()
                .withSourceImage(selfie)
                .withTargetImage(idFront)
                .withSimilarityThreshold(70F);
        CompareFacesResult result = rekognitionClient.compareFaces(request);
        List<CompareFacesMatch> faceMatches = result.getFaceMatches();
        if (faceMatches.size() > 0) {
            Float similarityScore = faceMatches.get(0).getSimilarity();
            if (similarityScore > 70F) {
                logger.log(Level.INFO,"Las imágenes SI pertenecen a la misma persona");
                return true;
            }
        }
        logger.log(Level.INFO,"Las imágenes NO pertenecen a la misma persona");
        throw new RejectedRequest("La Selfie no coincide con la documentación provista");
    }

}
