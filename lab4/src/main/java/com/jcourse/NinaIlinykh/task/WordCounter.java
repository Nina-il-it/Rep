package com.jcourse.NinaIlinykh.task;

import java.util.HashMap;
import java.util.Map;

public class WordCounter implements Comparable {
    public Map.Entry<String, Integer> periodicity;

    public WordCounter(Map.Entry<String, Integer> periodicity) {
        this.periodicity = periodicity;
    }

    /*сравниваем по значению, если значения разные.
    и по ключу, если значения одинаковые */
    @Override
    public int compareTo(Object wordCounter) {
        int flag = periodicity.getValue().compareTo(this.periodicity.getValue());
        if (flag == 0) {
            periodicity.getKey().compareTo(this.periodicity.getKey());
        }
        return flag;
    }

}
