class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    if (dfs(grid, i, j, m, n) % k == 0) {
                        ++ans;
                    }
                }
            }
        }

        return ans;
    }

    public static long dfs(int[][] grid, int r, int c, int mr, int mc) {
        if (r >= mr || c >= mc || r < 0 || c < 0) return 0;
        if (grid[r][c] == 0) return 0;

        long sum = 0;

        sum += grid[r][c];
        grid[r][c] = 0;

        return sum += dfs(grid, r + 1, c, mr, mc)
                    + dfs(grid, r, c + 1, mr, mc)
                    + dfs(grid, r - 1, c, mr, mc)
                    + dfs(grid, r, c - 1, mr, mc);
    }
}