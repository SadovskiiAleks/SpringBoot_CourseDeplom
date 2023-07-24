package com.example.spring_course.controller;

import com.example.spring_course.model.transfer.Transfer;
import com.example.spring_course.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransferController {

    @Autowired
    TransferService transferService;

    @CrossOrigin
    @PostMapping("/transfer")
    public ResponseEntity<?> transfer(@RequestBody Transfer transaction){
        System.out.println();
        System.out.println(transaction.toString());
        return transferService.transaction(transaction);
    }
}
