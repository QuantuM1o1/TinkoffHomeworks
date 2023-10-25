package edu.hw3;

import java.util.Comparator;
import java.util.TreeMap;

public class Task7 {
    private Task7() {
    }

    public static TreeMap<String, String> nullTree() {
        return new TreeMap<>(Comparator.nullsFirst(Comparator.naturalOrder()));
    }
}
