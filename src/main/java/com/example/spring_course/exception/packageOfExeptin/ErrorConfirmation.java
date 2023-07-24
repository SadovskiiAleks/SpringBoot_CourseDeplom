package com.example.spring_course.exception.packageOfExeptin;

public class ErrorConfirmation extends RuntimeException {
    int id;
    public ErrorConfirmation(String msg,int id) {
        super(msg);
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
