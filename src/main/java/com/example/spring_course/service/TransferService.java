package com.example.spring_course.service;

import com.example.spring_course.dto.exception.ErrorInputData;
import com.example.spring_course.dto.exception.ErrorTransfer;
import com.example.spring_course.model.OperationId;
import com.example.spring_course.model.transfer.Transfer;
import com.example.spring_course.repository.TransferRepository;
import com.example.spring_course.repository.TransferRepositoryInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransferService implements TransferServiceInterface {

    private final TransferRepositoryInterface transferRepository;

    public ResponseEntity<Object> transaction(Transfer transaction) {
        int idOfOperation;
        boolean isCardFromTransferValid = transferRepository.cardIsValid(transaction);
        boolean isCardToTransferValid = transferRepository.isHaveCardToAddMoney(transaction);
        if (!isCardFromTransferValid) {
            idOfOperation = transferRepository.rememberTransaction(transaction);
            log.warn("ID: " + idOfOperation + ". Confirmed transfer: false (Error input data: Invalid sender card details), " + transaction.toString());

            throw new ErrorInputData("Error input data: Invalid sender card details", idOfOperation);

        } else if (!isCardToTransferValid) {
            idOfOperation = transferRepository.rememberTransaction(transaction);
            log.warn("ID: " + idOfOperation + ". Confirmed transfer: false (Error input data: Invalid recipient card details), " + transaction.toString());
            throw new ErrorInputData("Error input data: Invalid recipient card details", idOfOperation);

        } else if (!transferRepository.transaction(transaction)) {
            idOfOperation = transferRepository.rememberTransaction(transaction);
            log.warn("ID: " + idOfOperation + ". Confirmed transfer: false(Error transfer: not enough money), " + transaction.toString());

            throw new ErrorTransfer("Error transfer: not enough money", idOfOperation);

        } else {
            idOfOperation = transferRepository.rememberTransaction(transaction);
            OperationId operationId = new OperationId(Integer.toString(idOfOperation));

            return ResponseEntity.status(HttpStatus.OK)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(operationId);
        }
    }
}
