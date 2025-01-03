package amazon;

public class GetOutlierValue {
    public int getOutlierValue(int[] arr) {
        int sum = 0;
        int max = arr[0];
        int secondMax = arr[0];
        for (int n : arr) {
            sum += n;
            if (n > max) {
                secondMax = max;
                max = n;
            } else {
                secondMax = Math.max(secondMax, n);
            }
        }

        // case 1: secondMax is the sum and max is the outlier
        if (secondMax * 2 + max == sum) return max;
        // case 2: max is the sum
        return sum - 2 * max;
    }
}
