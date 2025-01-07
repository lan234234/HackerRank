package amazon;

public class MaximizePartitions {

    public int maximizePartitions(int[] performance) {
        int andRes = 0xFFFFFFFF;
        int count = 0;
        for (int n : performance) {
            andRes &= n;
            if (andRes == 0) {
                count++;
                andRes = 0xFFFFFFFF;
            }
        }
        return count == 0 ? 1 : count;
    }

}
