package com.bendaten.trainer.chapter14;

import java.util.Comparator;

public class OnesComparator implements Comparator<Integer> {

    public int compare(Integer i, Integer j) {
        return Integer.compare(i % 10, j % 10);
    }
}
