package com.example.spring_course.exception.packageOfExeptin;

public class ErrorInputData extends RuntimeException {
    int id;
    public ErrorInputData(String msg, int id){
        super(msg);
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
