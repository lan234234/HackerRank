package mathworks;

/**
 * We are given an array of costs of items like [2, 5, 7, 11, ...].
 * The weight of an item is 2^(index) of the item.
 * We can pick an element any number of times.
 * What is the minimum cost with which we can achieve at least the given weight W.
 * Constraints are unknown.
 */
public class MinimumCost {
    public int minCost(int[] costs, int weight) {
        return dfs(costs, weight, new int[weight + 1]);
    }
    private int dfs(int[] costs, int target, int[] dp) {
        if (target == 0)    return 0;
        if (dp[target] != 0)  return dp[target];
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < costs.length; i++) {
            int curWeight = (int) Math.pow(2, i);
            if (curWeight > target) break;
            int rest = dfs(costs, target - curWeight, dp);
            if (rest == -1) continue;
            minCost = Math.min(minCost, costs[i] + rest);
        }
        dp[target] = minCost == Integer.MAX_VALUE ? -1 : minCost;
        return dp[target];
    }
}
