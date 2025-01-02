package amazon;

import java.util.*;

public class CountPairsWithDifference {
    int N;
    int MOD = 1000000007;
    long[] fact;

    public int solution(int[] arr, int wt) {
        N = 2000; // depending on constrains
        fact = new long[N];
        fact[0] = 1;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        long res = 1;
        if (wt == 0) {
            for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
                int count = entry.getValue();
                if (count % 2 != 0) {
                    return 0;
                }
                int half = count / 2;
                // combination = fact[count] / (fact[half] * 2 ^ (half))
                res = res * factorial(count) % MOD;
                res = res * modularInverse((int) (factorial(half) * power(2, half) % MOD)) % MOD;
            }
        } else {
            List<Integer> keys = new ArrayList<>(freq.keySet());
            Collections.sort(keys);

            for (int cur : keys) {
                int count = freq.get(cur);
                if (count == 0) continue;
                int pair = cur + wt;
                Integer pairCount = freq.get(pair);
                if (pairCount == null || pairCount < count) return 0;
                res = res * factorial(pairCount) % MOD * modularInverse(factorial(pairCount - count)) % MOD;
                freq.put(pair, pairCount - count);
            }
        }

        return (int) res;
    }


    private long factorial(int num) {
        // base case:
        if (fact[num] != 0)  return fact[num];

        fact[num] = factorial(num - 1) * (num % MOD) % MOD;
        return fact[num];
    }

    public long modularInverse(long a) {
        return power(a, MOD - 2);
    }

    public long power(long base, long exp) {
        long result = 1;
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exp /= 2;
        }
        return result;
    }
}
