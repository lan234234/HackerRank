package amazon;

import java.util.*;

/**
 * Get Max Charge
 *
 * A team of engineers at Amazon, using advanced simulation tools, are analyzing
 * a series of interconnected systems, where each system has a charge value
 * represented by charge[i] (which can be positive, negative, or zero).
 *
 * The engineers have a specialized tool that allows them to perform the following
 * operation: Select a system and remove it, causing the neighboring systems to
 * automatically merge and combine their charge values. If the removed system has
 * neighboring systems with charges x and y directly to its left and right, they
 * will combine to form a new system with charge x + y. No combination will take
 * place if the system is the leftmost or rightmost in the array.
 *
 * Since this process is computationally expensive, the engineers will simulate
 * the operation using Amazon's advanced tools.
 *
 * For example, if the system charges are [-3, 1, 4, -1, 5, -9], using the tool
 * on the 4th system (index 3) will result in the new sequence [-3, 1, 9, -9],
 * as the charges from the 3rd and 5th systems also combine to 4 + 5 = 9.
 * If they then use the tool on the 1st system in this new sequence, it will
 * become [1, 9, -9].
 *
 * Function Description
 *
 * Complete the function getMaxCharge in the editor below. The function must return
 * the maximum charge that can be obtained.
 *
 * getMaxCharge has the following parameter:
 *
 * List charge: a list of integers representing the charge values
 * Returns
 *
 * long integer: the maximum charge that can be obtained
 *
 * Example 1:
 *
 * Input:  charge = [-2, 4, 3, -2, 1]
 * Output: 4
 *
 * Example 2:
 *
 * Input:  charge = [-2, 4, 9, 1, -1]
 * Output: 9
 *
 * Example 3:
 *
 * Input:  charge = [-1, 3, 2]
 * Output: 3
 */
public class GetMaxCharge {

    /**
     * solution 1: dfs
     */
    public long solution1(List<Integer> charge) {
        // corner case:
        if (charge.size() == 1) return charge.get(0);
        // general case:
        long[] max = new long[] {Long.MAX_VALUE};
        dfs(charge, new ArrayDeque<>(), max, 0);
        return max[0];
    }

    private void dfs(List<Integer> charge, Deque<Long> stack, long[] max, int index) {
        if (index == charge.size()) {
            if (stack.size() == 1) {
                max[0] = Math.max(max[0], stack.peekFirst());
            }
            return;
        }
        if (stack.isEmpty()) {
            // case 1: remove
            dfs(charge, stack, max, index + 1);
            // case 2: keep
            stack.offerFirst((long) charge.get(0));
            dfs(charge, stack, max, index + 1);
            stack.pollFirst();
        } else {
            // case 1: remove all remaining charge
            dfs(charge, stack, max, charge.size() + 1);
            // case 2: add to stack
            if (stack.size() == 1) {

            }

            // case 2: remove + merge
            if (index + 1 < charge.size()) {
                long oldCharge = stack.pollFirst();
                stack.offerFirst(oldCharge + (long) charge.get(index + 1));
                dfs(charge, stack, max, index + 2);
                stack.pollFirst();
                stack.offerFirst(oldCharge);
            }

        }
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
                dp[i] = charge.get(i) + (maxEven > 0 ? maxEven : 0);
                maxEven = Math.max(dp[i], maxEven);
            } else {
                dp[i] = charge.get(i) + (maxOdd > 0 ? maxOdd : 0);
                maxOdd = Math.max(dp[i], maxOdd);
            }
        }
        return Math.max(maxEven, maxOdd);
    }



}
