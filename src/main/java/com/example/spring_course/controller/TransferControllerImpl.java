package com.example.spring_course.controller;

import com.example.spring_course.dto.ConfirmOperation;
import com.example.spring_course.model.OperationId;
import com.example.spring_course.model.transfer.Transfer;
import com.example.spring_course.service.ConfirmOperationService;
import com.example.spring_course.service.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class TransferControllerImpl implements TransferController {

    private final TransferService transferService;
    private final ConfirmOperationService confirmOperationService;

    @PostMapping("/transfer")
    @CrossOrigin(origins = "${transfer.url}")
    public ResponseEntity<OperationId> transfer(@RequestBody Transfer transaction) {
        return ResponseEntity.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(transferService.transaction(transaction));
    }

    @PostMapping("/confirmOperation")
    @CrossOrigin(origins = "${confirm.operation.url}")
    public ResponseEntity<OperationId> confirmOperation(@RequestBody ConfirmOperation confirmOperation) {
        return ResponseEntity.ok().body(confirmOperationService.confirmOperation(confirmOperation));
    }
}
