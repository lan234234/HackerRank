package amazon;

public class MinimumEnergyCost {
    public int minimumEnergyCost(int[] weights, int X, int Y, int El, int Er) {
        int N = weights.length;

        // Initialize DP arrays
        int[][] dp = new int[N + 1][2];

        // Base cases
        dp[1][0] = X * weights[0]; // Collect the first bag from the left
        dp[1][1] = Y * weights[N - 1]; // Collect the first bag from the right

        // Fill DP table
        for (int i = 2; i <= N; i++) {
            // Collect the i-th bag from the left
            dp[i][0] = Math.min(dp[i - 1][0] + X * weights[i - 1] + El,
                    dp[i - 1][1] + X * weights[i - 1]);

            // Collect the i-th bag from the right
            dp[i][1] = Math.min(dp[i - 1][0] + Y * weights[N - i],
                    dp[i - 1][1] + Y * weights[N - i] + Er);
        }

        // Return the minimum cost to collect all bags
        return Math.min(dp[N][0], dp[N][1]);
    }
}
