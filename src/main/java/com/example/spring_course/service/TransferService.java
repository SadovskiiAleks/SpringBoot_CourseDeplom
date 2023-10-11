package com.example.spring_course.service;

import com.example.spring_course.model.OperationId;
import com.example.spring_course.model.transfer.Transfer;
import org.springframework.stereotype.Service;

@Service
public interface TransferService {
    OperationId transaction(Transfer transaction);
}
