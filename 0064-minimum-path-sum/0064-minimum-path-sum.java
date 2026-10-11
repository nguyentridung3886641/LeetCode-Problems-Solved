class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] mem = new int[m][n];
        for (int[] row : mem) {
            Arrays.fill(row, -1);
        }

        return dp(grid, mem, m - 1, n - 1);
    }

    public int dp(int[][] grid, int[][] mem, int r, int c) {
        if (r < 0 || c < 0) return Integer.MAX_VALUE;
        if (r == 0 && c == 0) return grid[r][c];
        if (mem[r][c] != -1) return mem[r][c];

        return mem[r][c] = Math.min(dp(grid, mem, r - 1, c), dp(grid, mem, r, c - 1)) + grid[r][c];
    }
}