package com.example.spring_course.service;

import com.example.spring_course.model.transfer.Transfer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface TransferServiceInterface {
    ResponseEntity<Object> transaction(Transfer transaction);
}
