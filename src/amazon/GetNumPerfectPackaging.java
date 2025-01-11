package amazon;

public class GetNumPerfectPackaging {

    public int getNumPerfectPackaging(int[] prices) {
        int n = prices.length;
        // corner case:
        if (n == 1)  return 5;

        // general case:
        int MOD = 1000000007;
        // dp[i][s] represents the number of perfect package
        // when we labeled the first i package with ith package labeled as s
        long[][] dp = new long[n][6];

        for (int s = 1; s <= 5; s++) {
            dp[0][s] = 1;
        }

        for (int i = 1; i < n; i++) {
            // prefixSum of the row dp[i - 1]
            long[] prefixSum = new long[6];
            for (int s = 1; s <= 5; s++) {
                prefixSum[s] = (prefixSum[s - 1] + dp[i - 1][s]) % MOD;
            }

            // fill dp[i][s]
            for (int s = 1; s <= 5; s++) {
                if (prices[i] > prices[i - 1]) {
                    dp[i][s] = prefixSum[s - 1];
                } else if (prices[i] < prices[i - 1]) {
                    if (s == 5)  continue;
                    dp[i][s] = prefixSum[5] - prefixSum[s];  // suffixSum[s + 1]
                } else {
                    dp[i][s] = prefixSum[5] - dp[i - 1][s];
                }
                if (dp[i][s] < 0) {
                    dp[i][s] += MOD;
                }
            }
        }


        long res = 0;
        for (int s = 1; s <= 5; s++) {
            res = (res + dp[n - 1][s]) % MOD;
        }

        return (int) res;
    }

}
