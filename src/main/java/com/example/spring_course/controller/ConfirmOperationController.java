package com.example.spring_course.controller;

import com.example.spring_course.dto.ConfirmOperation;
import com.example.spring_course.service.ConfirmOperationService;
import com.example.spring_course.service.ConfirmOperationServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class ConfirmOperationController {

    private final ConfirmOperationServiceInterface confirmOperationService;

    @CrossOrigin
    @PostMapping("/confirmOperation")
    public ResponseEntity<Object> confirmOperation(@RequestBody ConfirmOperation confirmOperation) {
        return confirmOperationService.confirmOperation(confirmOperation);
    }
}
