package com.example.spring_course.service;

import com.example.spring_course.exception.ErrorInputData;
import com.example.spring_course.exception.ErrorTransfer;
import com.example.spring_course.model.OperationId;
import com.example.spring_course.model.transfer.Transfer;
import com.example.spring_course.repository.TransferRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransferServiceImpl implements TransferService {

    private final TransferRepository transferRepository;

    public OperationId transaction(Transfer transaction) {
        int idOfOperation;
        boolean isCardFromTransferValid = transferRepository.cardIsValid(transaction);
        boolean isCardToTransferValid = transferRepository.isHaveCardToAddMoney(transaction);
        if (!isCardFromTransferValid) {
            idOfOperation = transferRepository.rememberTransaction(transaction);
            log.warn(String.format("ID: %s. Confirmed transfer: false (Error input data: Invalid sender card details), %s",
                    idOfOperation,transaction.toString()));
            throw new ErrorInputData("Error input data: Invalid sender card details", idOfOperation);
        } else if (!isCardToTransferValid) {
            idOfOperation = transferRepository.rememberTransaction(transaction);
            log.warn(String.format("ID: %s. Confirmed transfer: false (Error input data: Invalid recipient card details), %s",
                    idOfOperation,transaction.toString()));
            throw new ErrorInputData("Error input data: Invalid recipient card details", idOfOperation);
        } else if (!transferRepository.transaction(transaction)) {
            idOfOperation = transferRepository.rememberTransaction(transaction);
            log.warn(String.format("ID: %s. Confirmed transfer: false(Error transfer: not enough money), %s",
                    idOfOperation,transaction.toString()));
            throw new ErrorTransfer("Error transfer: not enough money", idOfOperation);
        } else {
            idOfOperation = transferRepository.rememberTransaction(transaction);
            OperationId operationId = new OperationId(Integer.toString(idOfOperation));
            return operationId;
        }
    }
}
