package amazon;

public class GetMaximumZeros {
    public int findMaximumZeroes(int[] arr) {
        int res = 0;
        int min = arr[0];
        // find the non-ascending subarray length starting from index 0
        // also find the min in the subarray
        int i = 1;
        for (; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                res = i;
                break;
            } else if (arr[i] < arr[i - 1]) {
                min = arr[i];
            }
        }

        // find element equals to min in remaining part
        while (i < arr.length) {
            if (arr[i] == min) {
                res++;
            }
            i++;
        }

        return res;
    }

}
