package amazon;

public class MinSwapsToMakePalindrome {
    public int minSwapsToMakePalindrome(String s) {
        // corner case:
        if (s == null || s.length() <= 1)   return 0;
        // general case:
        int result = 0;
        int i = 0;
        int j = s.length() - 1;
        boolean needSwap = false;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                if (!needSwap) {
                    result++;
                }
                needSwap = !needSwap;
            }
            i++;
            j--;
        }
        if (i == j) return result;
        return needSwap ? -1 : result;
    }
}
