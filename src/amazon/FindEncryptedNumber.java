package amazon;

public class FindEncryptedNumber {
    public String findNumber(int[] numbers) {
        int n = numbers.length;
        while (n > 2) {
            for (int i = 0; i < n - 1; i++) {
                numbers[i] = (numbers[i] + numbers[i + 1]) % 10;
            }
            n--;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(numbers[0]);
        sb.append(numbers[1]);
        return sb.toString();
    }
}
