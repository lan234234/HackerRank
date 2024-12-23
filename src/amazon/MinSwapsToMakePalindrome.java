package amazon;

/**
 * Minimum Swaps to Make Palindrome
 * You are given a binary string, s, consisting of characters '0' and '1'.
 * Transform this string into a palindrome by performing some operations.
 * In one operation, swap any two characters, s[i] and s[j].
 * Determine the minimum number of swaps required to make the string a palindrome.
 * If it is impossible to do so, then return -1.
 *
 * Note: A palindrome is a string that reads the same backward as forward,
 * for example, strings "0", "111", "010", "10101" are palindromes,
 * but strings "001", "10", "11101" are not.
 *
 * Example 1:
 *
 * Input:  s = "0100101"
 * Output: 2
 *
 */
public class MinSwapsToMakePalindrome {
    public int minSwapsToMakePalindrome(String s) {
        // corner case:
        if (s == null || s.length() <= 1)   return 0;
        // general case:
        int result = 0;
        int left = 0;
        int right = s.length() - 1;
        // needSwap represents whether we need to find another bit to swap with
        // one of the current bits between s.charAt(i) and s.charAt(j)
        boolean needSwap = false;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                if (!needSwap) {
                    result++;
                }
                needSwap = !needSwap;
            }
            left++;
            right--;
        }
        if (left == right) return result;
        return needSwap ? -1 : result;
    }
}
