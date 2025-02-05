package mathworks;

public class ValidPasswords {
    int MOD = 1000000007;
    // dp[i][j]: i represents the length of password
    // j represents the repetitive times of the pre character
    long[][] dp;

    public int solution(int n, int k) {
        // corner case:
        if (k == 1) return 0;

        // general case:
        dp = new long[n + 1][k + 1];
        return (int) dfs(n, 0, k);
    }

    private long dfs(int remain, int preRepeat, int k) {
        if (preRepeat >= k)  return 0;
        if (remain == 0)    return 1;
        if (dp[remain][preRepeat] != 0)  return dp[remain][preRepeat];

        long res = 0;
        // case 1: choose different character
        int choice = preRepeat == 0 ? 26 : 25;
        res = (res + dfs(remain - 1, 1, k) * choice % MOD) % MOD;
        // case 2: choose same character
        if (preRepeat > 0) {
            res = (res + dfs(remain - 1, preRepeat + 1, k)) % MOD;
        }
        dp[remain][preRepeat] = res;
        return res;
    }
}
