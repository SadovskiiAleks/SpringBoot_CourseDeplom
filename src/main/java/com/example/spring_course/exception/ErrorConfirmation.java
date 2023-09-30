package com.example.spring_course.exception;

public class ErrorConfirmation extends BaseApplicationException {

    public ErrorConfirmation(String msg, int id) {
        super(msg, id);
    }

    public int getId() {
        return super.getId();
    }
}
