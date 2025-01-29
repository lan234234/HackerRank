package amazon;

public class GetMaxGreyness {


    public int getMaxGrayness(String[] pixels) {
        int m = pixels.length;
        int n = pixels[0].length();
        int[] row = new int[m];
        int[] col = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pixels[i].charAt(j) == '1') {
                    row[i]++;
                    col[j]++;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(2 * row[i] + 2 * col[j] - m - n, max);
            }
        }
        return max;
    }


}
