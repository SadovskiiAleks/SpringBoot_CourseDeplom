package com.example.spring_course.model;

import lombok.Data;

@Data
public class OperationId {
    String operationId;

    public OperationId (String operationId){
        this.operationId = operationId;
    }
}
