package com.jcourse.NinaIlinykh.task;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Reader reader = new InputStreamReader(new BufferedInputStream(new FileInputStream(args[0])));
        System.out.println(args[0]);
        HandlerWords handlerWords = new HandlerWords();
        handlerWords.writeWord(handlerWords.readWords(reader));
    }
}
