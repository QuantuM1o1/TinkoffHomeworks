package edu.hw3;

import java.util.Comparator;
import java.util.TreeMap;

public class Task4 {
    private Task4() {
    }

    final static TreeMap<Integer, String> MAP = new TreeMap<>(Comparator.reverseOrder());

    final static int I = 1;
    final static int IV = 4;
    final static int V = 5;
    final static int IX = 9;
    final static int X = 10;
    final static int XL = 40;
    final static int L = 50;
    final static int XC = 90;
    final static int C = 100;
    final static int CD = 400;
    final static int D = 500;
    final static int CM = 900;
    final static int M = 1000;

    static {
        MAP.put(I, "I");
        MAP.put(IV, "IV");
        MAP.put(V, "V");
        MAP.put(IX, "IX");
        MAP.put(X, "X");
        MAP.put(XL, "XL");
        MAP.put(L, "L");
        MAP.put(XC, "XC");
        MAP.put(C, "C");
        MAP.put(CD, "CD");
        MAP.put(D, "D");
        MAP.put(CM, "CM");
        MAP.put(M, "M");
    }

    final static String INCORRECT_INPUT = "Check input";
    final static int MAX_VALUE = 3999;

    public static String convertToRoman(int original) {
        if (original > MAX_VALUE || original < 1) {
            return INCORRECT_INPUT;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int arabic = original;
        for (int key : MAP.keySet()) {
            if (arabic / key > 0) {
                int numOfSymbols = arabic / key;
                arabic = arabic % key;
                for (int j = 0; j < numOfSymbols; j++) {
                    stringBuilder.append(MAP.get(key));
                }
            }
        }
        return stringBuilder.toString();
    }
}
