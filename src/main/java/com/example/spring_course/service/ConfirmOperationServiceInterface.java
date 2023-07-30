package com.example.spring_course.service;

import com.example.spring_course.dto.ConfirmOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ConfirmOperationServiceInterface {
    ResponseEntity<Object> confirmOperation(ConfirmOperation confirmOperation);
}
