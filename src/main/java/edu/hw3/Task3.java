package edu.hw3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Task3 {
    private Task3() {
    }

    public static String[] freqDict(Object[] originalArray) {
        ArrayList<String> array = new ArrayList<>();
        Map<Object, Integer> map = new HashMap<>();
        for (Object o : originalArray) {
            map.put(o, map.getOrDefault(o, 0) + 1);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (var o : map.keySet()) {
            stringBuilder.append(o.toString());
            stringBuilder.append(": ");
            stringBuilder.append(map.get(o));
            array.add(stringBuilder.toString());
            stringBuilder.setLength(0);
        }
        return array.toArray(new String[0]);
    }
}
