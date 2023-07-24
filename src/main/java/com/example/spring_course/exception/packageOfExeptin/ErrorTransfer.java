package com.example.spring_course.exception.packageOfExeptin;

public class ErrorTransfer extends RuntimeException{
    private final int id;
    public ErrorTransfer(String msg,int id){
        super(msg);
        this.id=id;
    }

    public int getId() {
        return id;
    }
}
