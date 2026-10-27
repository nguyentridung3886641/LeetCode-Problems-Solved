class Solution {
    public String[] createGrid(int m, int n) {
        String dot = ".";
        String hash = "#";

        String[] res = new String[m];
        res[0] = dot.repeat(n);

        for (int i = 1; i < m; i++) {
            res[i] = hash.repeat(n - 1) + dot;
        }

        return res;
    }
}