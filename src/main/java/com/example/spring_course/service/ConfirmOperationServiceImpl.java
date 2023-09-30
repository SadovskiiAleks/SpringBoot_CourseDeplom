package com.example.spring_course.service;

import com.example.spring_course.dto.ConfirmOperation;
import com.example.spring_course.exception.ErrorConfirmation;
import com.example.spring_course.exception.ErrorInputData;
import com.example.spring_course.model.OperationId;
import com.example.spring_course.repository.TransferRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ConfirmOperationServiceImpl implements ConfirmOperationService {

    private final TransferRepository transferRepository;

    public OperationId confirmOperation(ConfirmOperation confirmOperation) {


        if (!transferRepository.getTransferMap().containsKey(confirmOperation.getOperationId())) {
            //Проверить наличие операции по ID
            // Какую ощибку писать в лог ?
            log.warn("Ненайда операция");
            throw new ErrorConfirmation("Error confirmation: unknown id", confirmOperation.getOperationId());
        } else if (!transferRepository.checkConfirmOperation(confirmOperation)) {
            ///проверить верификационной код для пользователя по данной операции ID
            log.warn(String.format("ID: %s. Confirmed transfer: false(Error input data: incorrect secret code), %s",
                    confirmOperation.getOperationId(),
                    transferRepository.getTransferMap().get(confirmOperation.getOperationId()).toString()));
            throw new ErrorInputData("Error input data: incorrect secret code", confirmOperation.getOperationId());
        } else {
            log.info(String.format("ID: %s. Confirmed transfer: true,  %s",
                    confirmOperation.getOperationId(),
                    transferRepository.getTransferMap().get(confirmOperation.getOperationId()).toString()));
            OperationId operationId = new OperationId(Integer.toString(confirmOperation.getOperationId()));
            return operationId;
        }
    }
}
