package com.example.spring_course.exception.Handler;

import com.example.spring_course.exception.ErrorConfirmation;
import com.example.spring_course.exception.ErrorDto;
import com.example.spring_course.exception.ErrorInputData;
import com.example.spring_course.exception.ErrorTransfer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(ErrorInputData.class)
    public ResponseEntity<ErrorDto> errorInputData(ErrorInputData errorInputData) {
        ErrorDto errorDto = createErrorDto(errorInputData);
        return ResponseEntity.badRequest()
                .body(errorDto);
    }

    @ExceptionHandler(ErrorTransfer.class)
    public ResponseEntity<ErrorDto> errorTransfer(ErrorTransfer errorTransfer) {
        ErrorDto errorDto = createErrorDto(errorTransfer);
        return ResponseEntity.internalServerError()
                .body(errorDto);
    }

    @ExceptionHandler(ErrorConfirmation.class)
    public ResponseEntity<ErrorDto> errorConfirmation(ErrorConfirmation errorConfirmation) {
        ErrorDto errorDto = createErrorDto(errorConfirmation);
        return ResponseEntity.internalServerError()
                .header("description", "Error transfer")
                .body(errorDto);
    }

    public ErrorDto createErrorDto(ErrorTransfer errorTransfer) {
        String massage = errorTransfer.getMessage();
        int id = errorTransfer.getId();
        return new ErrorDto(massage, id);
    }

    public ErrorDto createErrorDto(ErrorConfirmation errorConfirmation) {
        String massage = errorConfirmation.getMessage();
        int id = errorConfirmation.getId();
        return new ErrorDto(massage, id);
    }

    public ErrorDto createErrorDto(ErrorInputData errorInputData) {
        String massage = errorInputData.getMessage();
        int id = errorInputData.getId();
        return new ErrorDto(massage, id);
    }
}
