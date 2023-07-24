package com.example.spring_course.service;

import com.example.spring_course.exception.packageOfExeptin.ErrorConfirmation;
import com.example.spring_course.exception.packageOfExeptin.ErrorInputData;
import com.example.spring_course.model.ConfirmOperation;
import com.example.spring_course.model.OperationId;
import com.example.spring_course.repository.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ConfirmOperationService {
    @Autowired
    TransferRepository transferRepository;
    @Autowired
    LoggerMy logger;

    public ResponseEntity<?> confirmOperation(ConfirmOperation confirmOperation) {

        System.out.println(confirmOperation.toString());

        if (!transferRepository.getTransferMap().containsKey(confirmOperation.getOperationId())) {
            //Проверить наличие операции по ID
            throw new ErrorConfirmation("Error confirmation: unknown id", confirmOperation.getOperationId());
            // Какую ощибку писать в лог ?

        } else if (!transferRepository.checkConfirmOperation(confirmOperation)) {
            ///проверить верификационной код для пользователя по данной операции ID
            logger.loggerLog(transferRepository.getTransferMap().get(confirmOperation.getOperationId()),
                    confirmOperation.getOperationId(),
                    false);
            throw new ErrorInputData("Error input data: incorrect secret code", confirmOperation.getOperationId());

        } else {
            // Записать успешное выполнение операции в лог
            logger.loggerLog(transferRepository.getTransferMap().get(confirmOperation.getOperationId()),
                    confirmOperation.getOperationId(),
                    true);
            OperationId operationId = new OperationId(Integer.toString(confirmOperation.getOperationId()));

            return ResponseEntity.status(HttpStatus.OK)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(operationId);
        }
    }
}
