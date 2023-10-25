package edu.hw3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Task2 {
    private Task2() {
    }

    private static final String[] INCORRECT_INPUT = new String[] {"Check input"};

    public static String[] clusterize(String unsorted) {
        ArrayDeque<Character> deque = new ArrayDeque<>();
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<String> sorted = new ArrayList<>();
        map.put('(', 0);
        map.put(')', 0);
        for (int i = 0; i < unsorted.length(); i++) {
            char c = unsorted.charAt(i);
            if (c == '(') {
                map.put(c, map.get(c) + 1);
                deque.add(c);
            } else if (c == ')') {
                if (deque.isEmpty()) {
                    return INCORRECT_INPUT;
                }
                map.put(c, map.get(c) + 1);
                deque.add(c);
                if (Objects.equals(map.get('('), map.get(')'))) {
                    while (!deque.isEmpty()) {
                        stringBuilder.append(deque.poll());
                    }
                    sorted.add(stringBuilder.toString());
                    stringBuilder.setLength(0);
                    map.put('(', 0);
                    map.put(')', 0);
                }
            } else {
                return INCORRECT_INPUT;
            }
        }
        if (!stringBuilder.isEmpty() || !deque.isEmpty()) {
            return INCORRECT_INPUT;
        }
        return sorted.toArray(new String[0]);
    }
}
