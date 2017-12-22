package com.jcourse.ninaIlinykh.task5;

import java.util.Stack;

public interface ExceptionGenerator {
    void generateNullPointerException(int num);

    void generateClassCastException(Object o);

    void generateNumberFormatException(String str);

    void generateStackOverflowError();

    void generateOutOfMemoryError();

    void generateMyException(Stack stack) throws MyException;
}
