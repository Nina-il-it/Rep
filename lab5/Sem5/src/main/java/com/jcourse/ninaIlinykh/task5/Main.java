package com.jcourse.ninaIlinykh.task5;

import java.util.Stack;

public class Main {
    public static void main(String[] args) throws MyException {
        ExceptionGeneratorImpl er = new ExceptionGeneratorImpl();
        /*NullPointer*/
        try {
            Integer num = null;
            er.generateNullPointerException(num);
        } catch (NullPointerException e) {
            System.out.println("NullPointer");
            e.printStackTrace();
        }
        /*StackOverFlow*/
        try {
            er.generateStackOverflowError();
        } catch (StackOverflowError e) {
            System.out.println("StackOverflow");
            e.printStackTrace();
        }
        /* ClassCastException */
        try {
            Main main = new Main();
            er.generateClassCastException(main);
        } catch (ClassCastException e) {
            System.out.println("ClassCast");
            e.printStackTrace();
        }
        /*NumberFormat*/
        try {
            String str = "chislo";
            er.generateNumberFormatException(str);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormat");
            e.printStackTrace();
        }
        /* OutOfMemory*/
        try {
            er.generateOutOfMemoryError();
        } catch (OutOfMemoryError e) {
            System.out.println("OutOfMemory");
            e.printStackTrace();
        }
        /* My Exception*/

        Stack stack = new Stack();
        er.generateMyException(stack);
    }
}