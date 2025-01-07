package amazon;

import java.util.Arrays;

public class GetMaxThroughput {
    public long amazonGetMaxThroughput(int[] host_throughput) {
        Arrays.sort(host_throughput);
        long res = 0;
        int left = 0;
        int right = host_throughput.length - 1;
        while (left < right) {
            left++;
            right--;
            if (left > right)  break;
            res += host_throughput[right--];
        }
        return res;
    }
}
