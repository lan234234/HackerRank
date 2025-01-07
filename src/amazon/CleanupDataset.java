package amazon;

import java.util.*;

public class CleanupDataset {

    public int cleanupDataset(String dataset, int x, int y) {
        Map<Character, Integer> mapping = new HashMap<>();
        char first = dataset.charAt(0);
        int n = dataset.length();
        int result = 0;

        // Build frequency map and determine the most frequent character
        for (char letter : dataset.toCharArray()) {
            mapping.put(letter, mapping.getOrDefault(letter, 0) + 1);
            if (letter != first && mapping.get(letter) > mapping.get(first)) {
                first = letter;
            }
        }

        int maxVal = mapping.get(first);

        // Determine the result based on the conditions
        if (y <= x) {
            if (n - maxVal < maxVal) {
                result = (n - maxVal) * y + (2 * maxVal - n) * x / 2;
            } else {
                result = n * y / 2;
            }
        } else {
            int count = 0;
            for (Map.Entry<Character, Integer> entry : mapping.entrySet()) {
                result += (entry.getValue() / 2) * x;
                count += (entry.getValue() / 2) * 2;
            }
            result += (n - count) / 2 * y;
        }

        return result;
    }
}

