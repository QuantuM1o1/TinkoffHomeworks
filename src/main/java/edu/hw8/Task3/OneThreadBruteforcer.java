package edu.hw8.Task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OneThreadBruteforcer implements PasswordBruteforcer {
    private final int maxLength;
    private final Map<String, String> map;
    private final Map<String, String> output;
    private final List<Character> characterList;
    private final int[] mask;

    public OneThreadBruteforcer(List<String> stringList, int maxLength) {
        mask = new int[maxLength];
        Arrays.fill(mask, -1);
        characterList = new ArrayList<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            characterList.add(c);
        }
        for (char c = 'a'; c <= 'z'; c++) {
            characterList.add(c);
        }
        for (char c = '0'; c <= '9'; c++) {
            characterList.add(c);
        }
        this.maxLength = maxLength;
        map = new HashMap<>();
        output = new HashMap<>();
        for (String s : stringList) {
            String[] split = s.split(" ");
            map.put(split[1], split[0]);
        }
    }

    @Override
    public Map<String, String> start() {
        while (!map.isEmpty()) {
            String possiblePassword = nextPassword();
            if (map.containsKey(HashGenerator.generateMD5Hash(possiblePassword))) {
                output.put(map.get(HashGenerator.generateMD5Hash(possiblePassword)), possiblePassword);
                map.remove(HashGenerator.generateMD5Hash(possiblePassword));
            }
        }
        return output;
    }

    private String nextPassword() {
        incrementMask(0);
        StringBuilder stringBuilder = new StringBuilder();
        return generatePassword(0, stringBuilder);
    }

    private String generatePassword(int position, StringBuilder stringBuilder) {
        if (position == maxLength) {
            return stringBuilder.toString();
        }
        if (mask[position] != -1) {
            stringBuilder.append(characterList.get(mask[position]));
        }
        return generatePassword(position + 1, stringBuilder);
    }

    private void incrementMask(int position) {
        if (position == mask.length) {
            return;
        }
        if (mask[position] + 1 == characterList.size()) {
            mask[position] = -1;
            incrementMask(position + 1);
        }
        mask[position]++;
    }
}
