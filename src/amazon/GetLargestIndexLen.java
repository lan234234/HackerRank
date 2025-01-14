package amazon;

import java.util.*;

public class GetLargestIndexLen {
    public int getLargestIndexLen(int[] feature1, int[] feature2) {
        int n = feature1.length;
        int[][] temp = new int[n][2];

        // Combine feature1 and feature2 into pairs
        for (int i = 0; i < n; i++) {
            temp[i][0] = feature1[i];
            temp[i][1] = feature2[i];
        }

        // Sort based on feature1 first, and then feature2 (if needed)
        Arrays.sort(temp, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(a[1], b[1]);
            }
        });

        int[] dp = new int[n];
        dp[0] = 1;
        int res = 1;

        // Find the longest sequence with the given conditions
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (temp[j][1] < temp[i][1] && temp[j][0] != temp[i][0]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }

}
