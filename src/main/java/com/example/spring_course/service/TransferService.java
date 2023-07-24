package com.example.spring_course.service;

import com.example.spring_course.exception.packageOfExeptin.ErrorInputData;
import com.example.spring_course.exception.packageOfExeptin.ErrorTransfer;
import com.example.spring_course.model.OperationId;
import com.example.spring_course.model.transfer.Transfer;
import com.example.spring_course.repository.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TransferService {


    @Autowired
    TransferRepository transferRepository;
    @Autowired
    LoggerMy logger;

    public ResponseEntity<?> transaction(Transfer transaction) {
        int idOfOperation;
        boolean isCardFromTransferValid = transferRepository.cardIsValid(transaction);
        boolean isCardToTransferValid = transferRepository.isHaveCardToAddMoney(transaction);
        if(!isCardFromTransferValid ){
            idOfOperation =  transferRepository.rememberTransaction(transaction);
            logger.loggerLog(transaction,idOfOperation,false);
            throw new ErrorInputData("Error input data: Invalid sender card details", idOfOperation);

        } else if (!isCardToTransferValid) {
            idOfOperation =  transferRepository.rememberTransaction(transaction);
            logger.loggerLog(transaction,idOfOperation,false);
            throw new ErrorInputData("Error input data: Invalid recipient card details", idOfOperation);

        } else if (!transferRepository.transaction(transaction)){
            idOfOperation =  transferRepository.rememberTransaction(transaction);
            logger.loggerLog(transaction,idOfOperation, false);
            throw new ErrorTransfer("Error transfer: not enough money", idOfOperation);

        } else {
            idOfOperation = transferRepository.rememberTransaction(transaction);
            //Узнать нужно ли запоминать операцию на данном этапе
           // logger.loggerLog(transaction,idOfOperation, true);
            OperationId operationId = new OperationId(Integer.toString(idOfOperation));

            return ResponseEntity.status(HttpStatus.OK)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(operationId);
        }
    }
}
