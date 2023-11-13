package edu.hw3;

public class Task1 {
    private Task1() {
    }

    private static final int MID_UPPERCASE = 78;
    private static final int MID_LOWERCASE = 110;

    public static String atbash(String original) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < original.length(); i++) {
            char c = original.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                c = (char) (c + (MID_UPPERCASE - c) * 2 - 1);
            } else if (c >= 'a' && c <= 'z') {
                c = (char) (c + (MID_LOWERCASE - c) * 2 - 1);
            }
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}
