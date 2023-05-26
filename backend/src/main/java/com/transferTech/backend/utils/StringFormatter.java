package com.transferTech.backend.utils;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.function.Function;

@Component
public class StringFormatter {

    public String formatName (String name){
        Function<String, String> addWhiteSpace = e -> e.concat(" ");

        return Arrays.stream(nameToStringArray(name))
                .map(firstLetterToUppercase())
                .map(addWhiteSpace)
                .reduce("", String::concat)
                .stripTrailing();
    }
    public String formatString (String string) {
        return firstLetterToUppercase().apply(string);
    }
    private static Function<String, String> firstLetterToUppercase() {
        return e -> e.substring(0, 1).toUpperCase() + e.substring(1).toLowerCase();
    }
    private static String[] nameToStringArray(String name) {
        return name.trim().split("\\s+");
    }
}
