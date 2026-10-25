class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    ans += (dfs(grid, i, j, m, n)) ? 1 : 0;
                }
            }
        }

        return ans;
    }

    public static boolean dfs(int[][] grid, int r, int c, int m, int n) {
        if (r >= m || c >= n || r < 0 || c < 0) return false;
        if (grid[r][c] == 1) return true;

        grid[r][c] = 1;

        boolean res = true;

        res &= dfs(grid, r + 1, c, m, n);
        res &= dfs(grid, r, c + 1, m, n);
        res &= dfs(grid, r - 1, c, m, n);
        res &= dfs(grid, r, c - 1, m, n);

        return res;
    }
}