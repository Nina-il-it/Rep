package com.jcourse.ninaIlinykh.task5;

public class MyException extends Exception {
    public MyException() {
    }

    public MyException(String message) {
        super(message);
        System.out.println(message);
    }

}
