package com.example.spring_course.dto.exception;

import com.example.spring_course.dto.exception.base.BaseApplicationException;

public class ErrorConfirmation extends BaseApplicationException {

    public ErrorConfirmation(String msg, int id) {
        super(msg, id);
    }

    public int getId() {
        return super.getId();
    }
}
