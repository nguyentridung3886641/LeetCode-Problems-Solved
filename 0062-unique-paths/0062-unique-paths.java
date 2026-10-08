class Solution {
    public int uniquePaths(int m, int n) {
        int[][] mem = new int[m][n];
        for (int[] row : mem) {
            Arrays.fill(row, -1);
        }

        return dp(m - 1, n - 1, mem);
    }

    public int dp(int m, int n, int[][] mem) {
        if (m == 0 && n == 0) {
            return 1;
        }

        if (m < 0 || n < 0) {
            return 0;
        }

        if (mem[m][n] != -1) {
            return mem[m][n];
        }

        return mem[m][n] = dp(m - 1, n, mem) + dp(m, n - 1, mem);
    }
}