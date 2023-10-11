package com.example.spring_course.exception;

public class ErrorInputData extends BaseApplicationException {
    public ErrorInputData(String msg, int id) {
        super(msg, id);
    }

    public int getId() {
        return super.getId();
    }
}
