package mathworks;

import java.util.Arrays;

public class DiscountTags {
    public int solution(int[] tags) {
        int minPosOdd = Integer.MAX_VALUE;
        int maxNegOdd = Integer.MIN_VALUE;
        int posSum = 0;
        for (int i = 0; i < tags.length; i++) {
            if (tags[i] > 0) {
                posSum += tags[i];
                if (posSum % 2 == 1) {
                    minPosOdd = Math.min(minPosOdd, tags[i]);
                }
            } else if (posSum % 2 == 1) {
                maxNegOdd = Math.max(maxNegOdd, tags[i]);
            }
        }
        if (posSum % 2 == 0)    return posSum;
        return minPosOdd > -maxNegOdd ? posSum + maxNegOdd : posSum - minPosOdd;
    }
}
