package edu.hw1;

public class Task5 {
    private Task5() {
    }

    public static boolean isPalindromeDescendant(int numberToCheck) {
        String palindrome = Integer.toString(numberToCheck);
        for (int i = 0; i < (palindrome.length() / 2); i++) {
            if (palindrome.charAt(i) != palindrome.charAt(palindrome.length() - 1 - i)) {
                if (palindrome.length() % 2 != 0) {
                    return false;
                }
                StringBuilder stringBuilder = new StringBuilder();
                for (int j = 0; j < palindrome.length() - 1; j += 2) {
                    int tempNumber = Character.getNumericValue(palindrome.charAt(j))
                        + Character.getNumericValue(palindrome.charAt(j + 1));
                    stringBuilder.append(tempNumber);
                }
                String newString = stringBuilder.toString();
                if (newString.length() < 2) {
                    return false;
                }
                return isPalindromeDescendant(Integer.parseInt(newString));
            }
        }
        return true;
    }
}
