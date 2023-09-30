package com.example.spring_course.exception;

public class ErrorTransfer extends BaseApplicationException {
    public ErrorTransfer(String msg, int id) {
        super(msg, id);
    }

    public int getId() {
        return super.getId();
    }
}
