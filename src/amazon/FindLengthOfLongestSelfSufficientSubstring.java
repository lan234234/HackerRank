package amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindLengthOfLongestSelfSufficientSubstring {

    /**
     * method 1: brute force
     * test cases: s: "amazomsarvicesa" -> 5 ("rvice")
     * a mazomsarvicesa
     */
    public int solution1(String s) {
        int n = s.length();
        if (n <= 1) return 0; // A proper substring can't be the entire string

        int maxLen = 0;

        // Try all possible substrings
        for (int i = 0; i < n; i++) {
            for (int len = 1; i + len <= n; len++) {
                // Skip if this would be the entire string
                if (len == n) continue;

                // Check if this substring is self-sufficient
                boolean isSelfSufficient = true;
                boolean[] inSubstring = new boolean[26];

                // Mark characters in the current substring
                for (int j = i; j < i + len; j++) {
                    inSubstring[s.charAt(j) - 'a'] = true;
                }

                // Check if any character appears outside the substring
                for (int j = 0; j < n; j++) {
                    if (j >= i && j < i + len) continue; // Skip the substring itself
                    if (inSubstring[s.charAt(j) - 'a']) {
                        isSelfSufficient = false;
                        break;
                    }
                }

                if (isSelfSufficient) {
                    maxLen = Math.max(maxLen, len);
                }
            }
        }

        return maxLen;
    }

    /**
     * method 2: sliding window
     */
    public int solution2(String s) {
        int res = -1;

        // left and right are used to store the leftmost and right most index of the character
        int[] left = new int[26];
        Arrays.fill(left, -1);
        int[] right = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (left[index] == -1) {
                left[index] = i;
            }
            right[index] = i;
        }

        // a self-sufficient substring must start with the leftmost of char1 and
        // end with the right most of char2, and char1 and char2 can be the same
        // try all possible (char1, char2) pair -> valid each character
        for (int i = 0; i < 26; i++) {  //  (char) (i + 'a') represent the char1
            if (left[i] == -1)  continue;
            int left1 = left[i];
            int right1 = right[i];
            int end = right1;   // end of the substring should >= right1
            for (int j = left1; j < s.length(); j++) {  // only consider the char after c1 in s
                if (left1 == 0 && j == s.length() - 1)  continue;   // skip full string
                int index = s.charAt(j) - 'a';
                int left2 = left[index];
                int right2 = right[index];
                end = Math.max(end, right2);
                if (left2 < left1)  break;  // invalid substring, no need to continue
                if (j == end) {
                    res = Math.max(res, right2 - left1 + 1);
                }
            }
        }
        return res;
    }

    /**
     * method 3: try all possible (c1, c2) pair
     */
    public int solution3(String s) {
        int res = -1;

        // left and right are used to store the leftmost and right most index of the character
        int[] left = new int[26];
        Arrays.fill(left, -1);
        int[] right = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (left[index] == -1) {
                left[index] = i;
            }
            right[index] = i;
        }

        // a self-sufficient substring must start with the leftmost of char1 and
        // end with the right most of char2, and char1 and char2 can be the same
        // try all possible (char1, char2) pair -> valid each character
        for (int i = 0; i < 26; i++) {  //  (char) (i + 'a') represent the char1
            if (left[i] == -1)  continue;
            int left1 = left[i];
            int right1 = right[i];
            int end = right1;   // end of the substring should >= right1
            for (int j = left1; j < s.length(); j++) {  // only consider the char after c1 in s
                if (left1 == 0 && j == s.length() - 1)  continue;   // skip full string
                int index = s.charAt(j) - 'a';
                int left2 = left[index];
                int right2 = right[index];
                end = Math.max(end, right2);
                if (left2 < left1)  break;  // invalid substring, no need to continue
                if (j == end) {
                    res = Math.max(res, right2 - left1 + 1);
                }
            }
        }
        return res;
    }
}
