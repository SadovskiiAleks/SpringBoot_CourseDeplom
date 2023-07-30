package com.example.spring_course.dto.exception;

import com.example.spring_course.dto.exception.base.BaseApplicationException;

public class ErrorTransfer extends BaseApplicationException {
    public ErrorTransfer(String msg, int id) {
        super(msg, id);
    }

    public int getId() {
        return super.getId();
    }
}
