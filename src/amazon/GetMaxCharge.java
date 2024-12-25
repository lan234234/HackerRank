package amazon;

import java.util.*;
import java.util.stream.Collectors;

public class GetMaxCharge {

    /**
     * solution 1: prefix
     * assume charge is [a, b, c, d, e ...], we can find the max charge should be within the following possible charge:
     * a, a + c, a + c + e, ...
     * b, b + d, b + d + f, ...
     * c, c + e, c + e + g, ...
     * d, d + f, ...
     * e, ...
     */
    public long solution1(List<Integer> charge) {
        return 0;

    }

    /**
     * solution 2: dynamic programming
     * dp[i]: represent the max charge when we merge the range [0, i] and i must not be removed
     * case 1: all charge before i are removed -> dp[i] = charge.get(i)
     * case 2: some charges before i are not removed -> dp[i] = charge.get(i) + max(dp[i-2],dp[i-4],dp[i-6],...)
     * final result is max in the dp
     */
    public long solution2(List<Integer> charge) {
        // corner case:
        if (charge.size() == 1) return charge.get(0);
        // general case:
        long[] dp = new long[charge.size()];
        long maxEven = Integer.MIN_VALUE;
        long maxOdd = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            if (i % 2 == 0) {
                dp[i] = charge.get(i) + maxEven > 0 ? maxEven : 0;
                maxEven = Math.max(dp[i], maxEven);
            } else {
                dp[i] = charge.get(i) + maxOdd > 0 ? maxOdd : 0;
                maxOdd = Math.max(dp[i], maxOdd);
            }
        }
        return Math.max(maxEven, maxOdd);
    }



}
