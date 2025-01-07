package amazon;

import java.util.ArrayList;
import java.util.List;

public class FindIdeaDays {
    public int[] findIdealDays(int[] day, int k) {
        int n = day.length;
        int[] nonIncrease = new int[n];
        int[] nonDecrease = new int[n];
        for (int i = 1; i < n; i++) {
            nonIncrease[i] = day[i] <= day[i - 1] ? nonIncrease[i - 1] : i;
            nonDecrease[i] = day[i] >= day[i - 1] ? nonDecrease[i - 1] : i;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = k; i + k < n; i++) {
            if (nonIncrease[i - k] == nonIncrease[i] && nonDecrease[i] == nonDecrease[i + k]) {
                res.add(i + 1);
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}
