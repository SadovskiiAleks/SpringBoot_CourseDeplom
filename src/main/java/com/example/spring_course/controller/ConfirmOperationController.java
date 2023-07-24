package com.example.spring_course.controller;

import com.example.spring_course.model.ConfirmOperation;
import com.example.spring_course.service.ConfirmOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class ConfirmOperationController {
    @Autowired
    ConfirmOperationService confirmOperationService;

    @CrossOrigin
    @PostMapping("/confirmOperation")
    public ResponseEntity<?> confirmOperation(@RequestBody ConfirmOperation confirmOperation){
        return confirmOperationService.confirmOperation(confirmOperation);
    }
}
