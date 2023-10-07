package edu.hw1;

public class Task4 {
    private Task4() {
    }

    public static String fixString(String originalString) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while ((i + 1) < originalString.length()) {
            stringBuilder.append(originalString.charAt(i + 1));
            stringBuilder.append(originalString.charAt(i));
            i += 2;
        }
        if (originalString.length() % 2 != 0) {
            stringBuilder.append(originalString.charAt(i));
        }
        return stringBuilder.toString();
    }
}
