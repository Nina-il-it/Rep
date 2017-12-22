package com.jcourse.NinaIlinykh.task;

import java.io.*;
import java.util.*;

public class HandlerWords {
    int totalWord;

    public HandlerWords() {
    }

    public List readWords(Reader reader) throws IOException {
        StringBuilder newWord = new StringBuilder();
        Map<String, Integer> definitions = new HashMap<>();
        int sim = 0;
        totalWord=0;
        /* Проверяем в первом цикле не является ли взятый символ концом файла*/
        while (sim != -1) {
            /* считываем слово до первого разделителя*/
            while (sim != -1) {
                sim = reader.read();
                char simChar = (char) sim;
                if (Character.isLetterOrDigit(simChar)) {
                    newWord.append(simChar);
                } else break;
            }
            /* если считалось слово, то записываем его в нашу Мар*/
            if (newWord.length() > 0) {
                String str = newWord.toString();
                totalWord++;
                newWord.delete(0, newWord.length());
                /*При этом проверяем, было ли оно ранее записано в Мар*/
                if (definitions.get(str) == null) {
                    definitions.put(str, 1);

                } else {
                    definitions.put(str, definitions.get(str) + 1);
                }
            }
        }
        System.out.println(definitions);
        /*Создаем и заполняем массив*/
        List<WordCounter> list = new ArrayList<>();
        for (Map.Entry<String, Integer> periodicity : definitions.entrySet()) {
            list.add(new WordCounter(periodicity));
        }
        /*сортируем его*/
        Collections.sort(list);
        /* количество слов=размеру МАР*/
//        totalWord = definitions.size();
        return list;
    }

    public void writeWord(List<WordCounter> list) throws IOException {

        /*Записываем обратно в файл*/
        Writer writer = null;
        try {
            writer = new OutputStreamWriter(new FileOutputStream("result.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (WordCounter line : list) {
            if (writer != null) {
                writer.write(line.periodicity.getKey() + ";" + line.periodicity.getValue() + ";" + (double) line.periodicity.getValue() / totalWord * 100 + "%\n");
                writer.flush();
            }
        }
        writer.close();
    }
}




