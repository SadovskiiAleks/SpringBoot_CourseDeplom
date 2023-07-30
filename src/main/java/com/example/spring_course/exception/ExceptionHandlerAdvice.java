package com.example.spring_course.exception;

import com.example.spring_course.dto.exception.ErrorConfirmation;
import com.example.spring_course.dto.exception.ErrorInputData;
import com.example.spring_course.dto.exception.ErrorTransfer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(ErrorInputData.class)
    public ResponseEntity<Object> errorInputData(ErrorInputData errorInputData) {

        String massage = errorInputData.getMessage();
        int id = errorInputData.getId();
        ErrorObject errorObject = new ErrorObject(massage, id);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(errorObject);

    }

    @ExceptionHandler(ErrorTransfer.class)
    public ResponseEntity<Object> errorTransfer(ErrorTransfer errorTransfer) {

        String massage = errorTransfer.getMessage();
        int id = errorTransfer.getId();
        ErrorObject errorObject = new ErrorObject(massage, id);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON)
                .body(errorObject);
    }

    @ExceptionHandler(ErrorConfirmation.class)
    public ResponseEntity<Object> errorConfirmation(ErrorConfirmation errorConfirmation) {

        String massage = errorConfirmation.getMessage();
        int id = errorConfirmation.getId();
        ErrorObject errorObject = new ErrorObject(massage, id);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .header("description", "Error transfer")
                .contentType(MediaType.APPLICATION_JSON)
                .body(errorObject);
    }
}
