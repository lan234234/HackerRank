package amazon;

import java.util.HashMap;

public class FindDominance {
    public int[] findDominance(String[] s) {
        // write your code here
        int m = s[0].length();
        int[] sol = new int[m];

        // solution: use a hashmap to count occurrences of each prefix, keeping track of the largest occurrence for each prefix length

        for (int i = 0; i < m; i++) {
            HashMap<String, Integer> counts = new HashMap<>();
            int maxCount = 0;
            for (int j = 0; j < s.length; j++) {
                String substr = s[j].substring(0, i+1);
                int count = counts.getOrDefault(substr, 0) + 1;
                counts.put(substr, count);
                maxCount = Math.max(maxCount, count);
            }
            sol[i] = maxCount;
        }
        return sol;
    }
}
