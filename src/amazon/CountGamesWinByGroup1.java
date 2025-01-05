package amazon;

import java.util.Arrays;

public class CountGamesWinByGroup1 {
    public int howManyGamesDidTheyWin(int n, int[] firstTeam, int[] secondTeam) {
        for (int i = 0; i < n; i++) {
            firstTeam[i] -= secondTeam[i];
        }
        Arrays.sort(firstTeam);
        int left = 0;
        int right = n - 1;
        long res = 0;
        int MOD = 1000000007;
        while (left < right) {
            int sum = firstTeam[left] + secondTeam[right];
            if (sum > 0) {
                res = (res + right - left) % MOD;
                right--;
            } else {
                left++;
            }
        }
        return (int) res;


    }
}
