package amazon;

import java.util.Arrays;

public class GetPairCount {
    public long getPairsCount(int[] process, int k) {
        // corner case:
        if (process.length == 1)    return 0;

        // general case:
        long res = 0;
        Arrays.sort(process);
        int left = 0;
        int right = 1;
        while (right< process.length) {
            while (process[right] - process[left] > k) {
                left++;
            }
            if (right > left) {
                res += (right - left);
            }
            right++;
        }
        return res;
    }
}
