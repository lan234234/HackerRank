package amazon;

import java.util.*;

public class SumOfDistinctCategories {
    public int sumOfDistinctCategories(int[] categories) {
        int n = categories.length;
        // cur is the contribution of substring end with current category
        int res = 0;
        int cur = 0;
        Map<Integer, Integer> mp = new HashMap<>(); // To track the last occurrence of each category

        for (int i = 0; i < n; i++) {
            // cur[i] = cur[i - 1] + i + 1 - mp.get(category[i])
            // in above equation, i + 1 means each substring plus a unique element
            // - mp.get(category[i]) is to remove the dup
            // e.g., if i is a unique one, we can easily understand that cur[i] = cur[i - 1] + i + 1
            cur += i + 1 - (i == 0 ? 0 : mp.getOrDefault(categories[i], 0));

            // Add the current contribution to the total answer
            res += cur;

            // Update the last occurrence index of the current category
            mp.put(categories[i], i + 1);
        }

        return res;
    }

    /**
     * brute force
     */
    public int solution1(int[] categories) {
         int n = categories.length;
         int res = 0;
         for (int i = 0; i < n; i++) {
           Set<Integer> set = new HashSet<>();
           int left = i;
           for (int right = i; right < n; right++) {
             set.add(categories[right]);
             res += set.size();
           }
         }
         return res;
    }
}
