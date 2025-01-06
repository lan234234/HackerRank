package amazon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimizeEffort {
    /**
     * sort + traverse
     * O(n^2)
     */
    public int solution1(int[] effort) {
        Arrays.sort(effort);
        int res = effort[0];
        for (int i = 1; i < effort.length; i++) {
            res += effort[i];
            for (int j = 0; j < i; j++) {
                if (effort[i] % effort[j] == 0) {
                    res = res - effort[i] + effort[j];
                    break;
                }
            }
        }
        return res;
    }

    /**
     * set + factor traverse
     * O(n * max^0.5)
     */
    public int solution2(List<Integer> nums) {
        long sum = 0;
        Set<Integer> set = new HashSet<>(nums);

        for (int num : nums) {
            int minVal = num;
            for (int j = 2; j * j <= num; j++) {
                if (num % j == 0) {
                    if (set.contains(j)) {
                        minVal = Math.min(minVal, j);
                    }
                    int k = num / j;
                    if (set.contains(k)) {
                        minVal = Math.min(minVal, k);
                    }
                }
            }
            sum += minVal;
        }

        return (int) sum;
    }

    /**
     *
     * O(max^2)
     */
    public int minimizeEffort(int[] effort) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i : effort) {
            max = Math.max(i, max);
            min = Math.min(i, min);
        }
        if (min == 1) {
            return  effort.length;
        }

        int[] mp = new int[max + 1];

        for (int n : effort) {
            mp[n]++;
        }

        int ans = 0;
        for (int i = min; i <= max; i++) {
            if (mp[i] == 0) {
                continue;
            }
            for (int j = i; j <= max; j += i) {
                ans += mp[j] * i;
                mp[j] = 0;
            }
        }

        return ans;
    }
}
