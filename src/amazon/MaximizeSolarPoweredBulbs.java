package amazon;

public class MaximizeSolarPoweredBulbs {
    public int maximizeSolarPoweredBulbs(String bulbs) {
        int count = 0;
        char pre = '0';
        for (int i = 0; i < bulbs.length(); i++) {
            if (bulbs.charAt(i) == '0' && (pre == '1' || (i + 1 < bulbs.length() && bulbs.charAt(i + 1) == '1'))) {
                pre = '0';
            } else {
                pre = '1';
                count++;
            }
        }
        return count;
    }
}
