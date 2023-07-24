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

    public ResponseEntity<?> confirmOperation(ConfirmOperation confirmOperation) {

        //Проверить правильность верификационного кода
        // проверить верификационный код по ID операции.
        System.out.println(confirmOperation.toString());
        //!!!!!!1~
        OperationId operationId = new OperationId("1223");
        int id = 100;
        //Проверить как получаються ID

        if (false){
            ///проверить верификационной код
            throw new ErrorInputData("Error input data", id);
        } else if (false) {
            //Проверить на ошибку ????
            throw new ErrorConfirmation("Error confirmation", id);
        } else if (true) {
            return ResponseEntity.status(HttpStatus.OK)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(operationId);
        }

        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }
}
