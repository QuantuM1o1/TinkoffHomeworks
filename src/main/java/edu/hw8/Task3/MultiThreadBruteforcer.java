package edu.hw8.Task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadBruteforcer implements PasswordBruteforcer {
    private final int maxLength;
    private final Map<String, String> map;
    private final Map<String, String> output;
    private final List<Character> characterList;
    private final int[] mask;
    private final int numberOfThreads;
    private final static int SECOND_NUMBER_OF_MASK_NEEDED = -2;

    public MultiThreadBruteforcer(List<String> stringList, int maxLength, int numberOfThreads) {
        this.numberOfThreads = numberOfThreads;
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
        map = new ConcurrentHashMap<>();
        output = new HashMap<>();
        for (String s : stringList) {
            String[] split = s.split(" ");
            map.put(split[1], split[0]);
        }
    }

    @Override
    public Map<String, String> start() {
        try (ExecutorService service = Executors.newFixedThreadPool(numberOfThreads)) {
            for (int i = 0; i < characterList.size(); i++) {
                int[] array = mask.clone();
                array[0] = i;
                if (array.length > 1) {
                    array[1] = SECOND_NUMBER_OF_MASK_NEEDED;
                }
                service.execute(() -> {
                     do {
                         String possiblePassword = nextPassword(array);
                         if (map.containsKey(HashGenerator.generateMD5Hash(possiblePassword))) {
                            output.put(map.get(HashGenerator.generateMD5Hash(possiblePassword)), possiblePassword);
                            map.remove(HashGenerator.generateMD5Hash(possiblePassword));
                         }
                    } while (array[array.length - 1] != characterList.size() - 1 || array.length == 1);
                });
            }
            while (!map.isEmpty()) {
                service.shutdown();
            }
        }
        return output;
    }

    private String nextPassword(int[] array) {
        incrementMask(1, array);
        StringBuilder stringBuilder = new StringBuilder();
        return generatePassword(0, stringBuilder, array);
    }

    private String generatePassword(int position, StringBuilder stringBuilder, int[] array) {
        if (position == maxLength) {
            return stringBuilder.toString();
        }
        if (array[position] != -1 && array[position] != SECOND_NUMBER_OF_MASK_NEEDED) {
            stringBuilder.append(characterList.get(array[position]));
        }
        return generatePassword(position + 1, stringBuilder, array);
    }

    private void incrementMask(int position, int[] array) {
        if (position == array.length) {
            return;
        }
        if (array[position] + 1 == characterList.size()) {
            array[position] = -1;
            incrementMask(position + 1, array);
        }
        array[position]++;
    }
}
