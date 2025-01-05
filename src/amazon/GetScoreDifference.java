package amazon;

import java.util.Arrays;

public class GetScoreDifference {
    public long getScoreDifference(int[] points) {
        // corner case:
        if (points.length == 1)  return points[0];
        // general case:
        Arrays.sort(points);
        int diff = 0;
        for (int i = points.length - 1; i >= 0; i -= 2) {
            diff += points[i];
        }
        for (int i = points.length - 2; i >= 0; i -= 2) {
            diff -= points[i];
        }
        return diff;
    }
}
