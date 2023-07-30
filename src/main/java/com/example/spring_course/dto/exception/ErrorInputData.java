package com.example.spring_course.dto.exception;

import com.example.spring_course.dto.exception.base.BaseApplicationException;

public class ErrorInputData extends BaseApplicationException {
    public ErrorInputData(String msg, int id) {
        super(msg, id);
    }

    public int getId() {
        return super.getId();
    }
}
