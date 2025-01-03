package amazon;

public class FindLengthOfLongestSelfSufficientSubstring {

    /**
     * method 1: brute force
     * test cases: s: "amazomsarvicesa" -> 5 ("rvice")
     * a mazomsarvicesa
     */
    public int findLengthOfLongestSelfSufficientSubstring(String s) {
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
}
