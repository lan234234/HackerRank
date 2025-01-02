package amazon;

public class GetDataDependenceSum {

    /**
     * method 1: brute force
     */
    public long solution1(long n) {
        long res = 0;
        long pre = -1;
        for (long k = n + 1; k > 0; k--) {
            long x = n / k;
            if (pre == x)   continue;
            pre = x;
            res += x;
        }
        return res;
    }
    /**
     * method 2: binary search
     */
    public long solution2(long n) {
        long res = 0;
        long right = n + 1;
        for (long x = 1; x <= n; x++) {
            long k = binarySearch(n, x, right);
            if (k != -1) {
                res += n / k;
                right = k - 1;
            }
        }
        return res;
    }
    private long binarySearch(long n, long x, long right) {
        long left = 1;
        long k = -1;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (n / mid == x) {
                k = mid;
                left = mid + 1;
            } else if (n / mid > x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return k;
    }
}
