package com.example.spring_course.dto;

public record ConfirmOperation(String operationId, String code) {
    public int getOperationId() {
        return Integer.parseInt(this.operationId);
    }
}
