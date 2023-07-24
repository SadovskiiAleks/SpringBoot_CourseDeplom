package com.example.spring_course.controller;

import com.example.spring_course.model.Transfer;
import com.example.spring_course.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "http://localhost:5500/transfer", maxAge = 3600)
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
