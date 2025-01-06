package amazon;

public class GetNumberRedundancyFree {
    public int getNumberRedundancyFree(String password) {
        // corner case:
        if (password.length() == 1)  return 1;
        // general case:
        int res = 1;
        boolean[] freq = new boolean[26];
        int left = 0;
        int right = 0;
        while (right < password.length()) {
            int charIndex = password.charAt(right) - 'a';
            if (freq[charIndex]) {
                res++;
                while (left < right) {
                    freq[password.charAt(left++) - 'a'] = false;
                }
            }
            freq[charIndex] = true;
            right++;
        }
        return res;
    }
}
