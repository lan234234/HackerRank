package amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountProcessesGivingInaccurateResults {
    public int countInaccurateResults(int[] processOrder, int[] executionOrder) {
        int n = processOrder.length;

        // step 1: convert element in executionOrder to its corresponding index in processOrder
        Map<Integer, Integer> processIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            processIndex.put(processOrder[i], i);
        }
        for (int i = 0; i < n; i++) {
            executionOrder[i] = processIndex.get(executionOrder[i]);
        }

        int count = 0;
        // finding target from 0 to n - 1 in executionOrder
        int target = 0;
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (visited.contains(target)) {
                target++;
                i--;
            } else if (target == executionOrder[i]) {
                target++;
            } else {
            // the element larger than target and located before target is inaccurate
                count++;
                visited.add(executionOrder[i]);
            }
        }
        return count;
    }
}
