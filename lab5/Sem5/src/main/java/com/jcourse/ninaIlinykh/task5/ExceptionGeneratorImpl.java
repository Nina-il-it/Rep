package com.jcourse.ninaIlinykh.task5;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

public class ExceptionGeneratorImpl implements ExceptionGenerator {

    public void generateNullPointerException(int num) {
        num++;
    }

    public void generateClassCastException(Object o) {
        ExceptionGeneratorImpl exceptionGenerator = (ExceptionGeneratorImpl) o;

    }

    public void generateNumberFormatException(String str) {
        int a = Integer.parseInt(str);
    }

    public void generateStackOverflowError() {
        generateStackOverflowError();
    }

    public void generateOutOfMemoryError() {
        long[] a = new long[2000000000];
        long[] b = new long[2000000000];
    }

    public void generateMyException(Stack stack) throws MyException {

        if (stack.empty()) {
            throw new MyException("StackEmpty");
        }

    }
}
