package com.example.spring_course.controller;

import com.example.spring_course.model.transfer.Transfer;
import com.example.spring_course.service.TransferService;
import com.example.spring_course.service.TransferServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TransferController {

    private final TransferServiceInterface transferService;


    @CrossOrigin
    @PostMapping("/transfer")
    public ResponseEntity<Object> transfer(@RequestBody Transfer transaction) {
        return transferService.transaction(transaction);
    }
}
