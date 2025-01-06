package amazon;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxTransferRate {

    public long maxTransferRate(int[] throughput, int pipelineCount) {
        long res = 0;
        int n = throughput.length;
        Arrays.sort(throughput);
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((arr1, arr2) -> (compare(arr2, arr1, throughput)));
        maxHeap.offer(new int[]{n - 1, n - 1});
        boolean[][] visited = new boolean[n][n];
        visited[n - 1][n - 1] = true;
        int[][] steps = new int[][]{{0, -1}, {-1, 0}};
        while (pipelineCount > 0) {
            int[] cur = maxHeap.poll();
            res += sum(cur, throughput);
            pipelineCount--;
            for (int[] step : steps) {
                int idx0 = cur[0] + step[0];
                int idx1 = cur[1] + step[1];
                if (idx0 >= 0 && idx1 >= 0 && !visited[idx0][idx1]) {
                    maxHeap.offer(new int[]{idx0, idx1});
                }
            }
        }
        return res;
    }

    private long sum(int[] indexes, int[] throughput) {
        return throughput[indexes[0]] + throughput[indexes[1]];
    }

    private int compare(int[] arr1, int[] arr2, int[] throughput) {
        long diff = sum(arr1, throughput) - sum(arr2, throughput);
        if (diff == 0)  return 0;
        return diff > 0 ? 1 : -1;
    }

}
