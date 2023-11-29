package edu.hw5;

public class Task6 {
    private Task6() {
    }

    public static boolean subsequenceChecker(String s, String t) {
        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(".*");
        for (char c : chars) {
            stringBuilder.append("[");
            if (c == '\\') {
                stringBuilder.append('\\');
            }
            stringBuilder.append(c);
            stringBuilder.append("]");
            stringBuilder.append(".*");
        }
        return t.matches(stringBuilder.toString());
    }
}
