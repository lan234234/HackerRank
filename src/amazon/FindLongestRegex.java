package amazon;

public class FindLongestRegex {
    public String findLongestRegex(String x, String y, String z) {
        // corner case:
        if (x.length() != y.length() || x.length() != z.length())   return "-1";

        // general case
        int index = -1;
        int c = -1;
        for (int i = 0; i < x.length(); i++) {
            if (z.charAt(i) != y.charAt(i) && z.charAt(i) != x.charAt(i)) {
                index = i;
                c = z.charAt(i) - 'A';
            }
        }

        if (index == -1) return "-1";

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < x.length(); i++) {
            if (i != index) {
                res.append("[ABCDEFGHIJKLMNOPQRSTUVWXYZ]");
            } else {
                res.append(build(c));
            }
        }
        return res.toString();
    }

    private String build(int remove) {
        StringBuilder cur = new StringBuilder();
        cur.append('[');
        for (int i = 0; i < 26; i++) {
            if (i != remove) {
                cur.append((char) ('A' + i));
            }
        }
        cur.append(']');
        return cur.toString();
    }
}
