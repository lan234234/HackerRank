package amazon;

import java.util.HashMap;
import java.util.Map;

public class GetStablePeriodCount {
    public int getStablePeriodsCount(int[] revenues, int k) {
        int MOD = 1000000007;
        long res = 0L;
        Map<Integer, Integer> freq = new HashMap<>();
        int i = 0;
        int j = 0;
        while (j < revenues.length) {
            int count = freq.getOrDefault(revenues[j], 0);
            freq.put(revenues[j++], count + 1);
            while (freq.size() > k) {
                count = freq.get(revenues[i]);
                if (count == 1) {
                    freq.remove(revenues[i]);
                } else {
                    freq.put(revenues[i], count - 1);
                }
                i++;
            }
            res = (res + j - i) % MOD;
        }
        return (int) res;
    }
}
