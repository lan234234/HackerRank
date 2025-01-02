package amazon;

import java.util.Arrays;

public class GetSuccessValue {
    public int[] getSuccessValue(int[] queries, int[] num_viewers) {
        Arrays.sort(num_viewers);
        Integer[] sums = new Integer[num_viewers.length];
        sums[0] = num_viewers[num_viewers.length - 1];
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = getSum(queries[i] - 1, sums, num_viewers);
        }
        return res;
    }
    private int getSum(int index, Integer[] sums, int[] arr) {
        // corner case:
        if (sums[index] != null)    return sums[index];

        // general case:
        sums[index] = getSum(index - 1, sums, arr) + arr[arr.length - 1 - index];
        return sums[index];
    }
}
