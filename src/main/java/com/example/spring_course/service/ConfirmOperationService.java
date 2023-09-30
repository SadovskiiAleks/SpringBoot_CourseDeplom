package com.example.spring_course.service;

import com.example.spring_course.dto.ConfirmOperation;
import com.example.spring_course.model.OperationId;
import org.springframework.stereotype.Service;

@Service
public interface ConfirmOperationService {
    OperationId confirmOperation(ConfirmOperation confirmOperation);
}
