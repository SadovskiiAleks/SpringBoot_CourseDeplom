package com.example.spring_course.service;

import com.example.spring_course.dto.ConfirmOperation;
import com.example.spring_course.dto.exception.ErrorConfirmation;
import com.example.spring_course.dto.exception.ErrorInputData;
import com.example.spring_course.model.OperationId;
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
public class ConfirmOperationService implements ConfirmOperationServiceInterface {

    private final TransferRepositoryInterface transferRepository;

    public ResponseEntity<Object> confirmOperation(ConfirmOperation confirmOperation) {


        if (!transferRepository.getTransferMap().containsKey(confirmOperation.getOperationId())) {
            //Проверить наличие операции по ID
            // Какую ощибку писать в лог ?
            log.warn("Ненайда операция");
            throw new ErrorConfirmation("Error confirmation: unknown id", confirmOperation.getOperationId());

        } else if (!transferRepository.checkConfirmOperation(confirmOperation)) {
            ///проверить верификационной код для пользователя по данной операции ID
            log.warn("ID: " + confirmOperation.getOperationId() + ". Confirmed transfer: false(Error input data: incorrect secret code), " + transferRepository.getTransferMap().get(confirmOperation.getOperationId()).toString());
            throw new ErrorInputData("Error input data: incorrect secret code", confirmOperation.getOperationId());

        } else {
            // Записать успешное выполнение операции в лог
            log.info("ID: " + confirmOperation.getOperationId() + ". Confirmed transfer: true, " + transferRepository.getTransferMap().get(confirmOperation.getOperationId()).toString());

            OperationId operationId = new OperationId(Integer.toString(confirmOperation.getOperationId()));

            return ResponseEntity.status(HttpStatus.OK)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(operationId);
        }
    }
}
