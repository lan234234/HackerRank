package mathworks;

import java.util.Arrays;

public class SubarrayPermutaion {
    public boolean[] solution(int[] A) {
        int n = A.length;
        Integer[] indexes = new Integer[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }
        Arrays.sort(indexes, (a, b) -> (A[a] - A[b]));

        boolean[] result = new boolean[n + 1];
        result[1] = true;
        int minIndex = Integer.MAX_VALUE;
        int maxIndex = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int curIndex = indexes[i];
            minIndex = Math.min(minIndex, curIndex);
            maxIndex = Math.max(maxIndex, curIndex);
            result[i + 1] = maxIndex - minIndex == i;
        }
        return result;
    }
}
