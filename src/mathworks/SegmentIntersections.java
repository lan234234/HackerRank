package mathworks;

import java.util.Arrays;

public class SegmentIntersections {
    public int[] solution(int[] startsAt, int[] endsAt) {
        int n = startsAt.length;
        Integer[] indexes = new Integer[n];
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }
        Arrays.sort(indexes, (a, b) -> {
            if (startsAt[a] == startsAt[b]) return endsAt[a] - endsAt[b];
            return startsAt[a] - startsAt[b];
        });

        int start = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            int curIndex = indexes[i];
            while (endsAt[indexes[start]] < startsAt[curIndex]) {
                start++;
            }
            while (end + 1 < n && startsAt[indexes[end + 1]] <= endsAt[curIndex]) {
                end++;
            }
            result[curIndex] = end - start;
        }

        return result;
    }
}
