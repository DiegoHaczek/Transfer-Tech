package com.transferTech.backend.repository;

import com.transferTech.backend.entity.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface TransferRepository extends JpaRepository<Transfer,Long> {

    @Transactional
    @Query(value = """
                 select
                 (case when sender_account_id is null then 'Deposito'
                  when sender_account_id= :Id then 'Transferencia Recibida'
                 else 'Transferencia Enviada' end) as type,*
                 from transfers where sender_account_id = :Id or receiver_account_id = :Id ;
              """
            ,nativeQuery=true)
    List<Map<String,Object>> getAllMovementsByUserId (@Param("Id") long userId);


}
