package mathworks;

import java.util.HashMap;
import java.util.Map;

public class MaximumOperations {
    public int maximumOperation(String s) {
        // arr[0]: the first index to do the operation
        // arr[1]: count of the char in [arr[0], n)
        Map<Character, int[]> map = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int[] cur = map.get(c);
            if (cur != null) {
                cur[1]++;
            } else if (i + 1 < n && c == s.charAt(i + 1)) {
                cur = new int[] {i + 2, 0};
                map.put(c, cur);
                i++;
            }
        }

        int max = 0;
        for (Map.Entry<Character, int[]> entry : map.entrySet()) {
            int[] cur = entry.getValue();
            max = Math.max(max, n - cur[0] - cur[1]);
        }
        return max;
    }
}
