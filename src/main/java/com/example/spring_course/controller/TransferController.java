package com.example.spring_course.controller;

import com.example.spring_course.dto.ConfirmOperation;
import com.example.spring_course.model.OperationId;
import com.example.spring_course.model.transfer.Transfer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface TransferController {
    public ResponseEntity<OperationId> transfer(@RequestBody Transfer transaction);

    public ResponseEntity<OperationId> confirmOperation(@RequestBody ConfirmOperation confirmOperation);
}
