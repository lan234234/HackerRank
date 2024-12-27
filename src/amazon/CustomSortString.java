package amazon;

/**
 * Custom Sort String
 *
 * AWS provides several utilities for language processing. Develop a helper service to sort a list of strings based on a custom order of characters.
 *
 * More formally, you are given a custom alphabet system that consists of exactly k characters. Their sorted alphabetical order is given by a string of distinct characters, order. An array arr contains n strings to sort according to the special ordering. Each string in arr contains only characters in order.
 *
 * Note: A string x = x1x2 ... xn is lexicographically smaller than string y = y1y2 ... ym if either n < m and x1 = y1, x2 = y2, ... xn = ym, or exists some number r (1 ≤ r < n, r < m), such that x1 = y1, x2 = y2, ... xr-1 = yr-1, xr < yr.
 *
 * Function Description
 *
 * Complete the function customSortString in the editor below.
 *
 * customSortString has the following parameters:
 *
 * string order: the custom order alphabet of k characters
 * string arr[n]: the strings to sort
 * Returns
 *
 * string(s): the sorted strings
 *
 * Example 1:
 *
 * Input:  order = "9AacB", arr = ["BBBBa", "BBBB9", "B9ca", "Aa999", "B9A", "B", "B9A"]
 * Output: ["Aa999", "B", "B9A", "B9A", "B9ca", "BBB89", "BBBBa"]
 * Explanation:
 *
 *
 * order = "9AacB" so 'A' comes before 'B', '9' comes before 'B', 'A' comes before 'c', 'c' comes before 'B', '9' comes before 'a'.
 *
 *
 *
 * The sorted order of strings is ["Aa999", "B", "B9A", "B9A", "B9ca", "BBB89", "BBBBa"].
 *
 *
 *
 * Example 2:
 *
 * Input:  order = "yYaAbBl", arr = ["Yay", "yaY", "lyab", "lyab", "b", "bay"]
 * Output: ["yaY", "Yay", "b", "bay", "lyab", "lyaB"]
 * Explanation:
 *
 *
 * tomtom highly recommend to go with this highlighted explanation -
 *
 * For example 2, order = "yYaAbB1". The last character might supposed to be letter l, not number one. hard to say. In the explanation they use number one, but it looks like letter l in the example. Regardless, make sure it's both letter l in arr and order or both number one in arr and order.
 *
 * - by spike in Nov 2024 :)
 *
 *
 * ( ＾◡＾)っ✂💔 -ˋˏ✄┈┈┈┈-ˋˏ✄┈┈┈┈-ˋˏ✄┈┈┈┈-ˋˏ✄┈┈┈┈-ˋˏ✄┈┈🧡 🐝
 *
 *
 * Original explanation from the source that is likely to be wrong -
 *
 * order = "yYaAbB1" so 'y' comes before 'Y', 'Y' is before 'b', 'b' is before '1', 'y' is before 'a' and 'b' is before 'B'.
 *
 *
 *
 * The sorted order of strings is ["yaY", "Yay", "b", "bay", "lyab", "lyaB"].
 *
 *
 *
 * Example 3:
 *
 * Input:  order = "7BbAz", arr = ["Abb", "A7z", "z7AAAA", "BbbABB"]
 * Output: ["BbbABB", "A7z", "Abb", "z7AAAA"]
 * Explanation:
 *
 *
 *
 *       The sorted srings are ["BbbABB", "A7z", "Abb", "z7AAAA"]
 *
 * Constraints:
 * 1 ≤ k ≤ 62
 * 1 ≤ n ≤ 10^5
 * The sum of lengths of all strings in arr does not exceed 10^6.
 * All characters of arr[] are present in order.
 * All characters of order are distinct and consist of [a-zA-Z0-9] only.
 */
public class CustomSortString {

}
