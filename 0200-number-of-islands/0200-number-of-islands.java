class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int islandsCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, m, n, grid);
                    ++islandsCount;
                }
            }
        }
        return islandsCount;
    }
    public static void dfs(int r, int c, int rl, int cl, char grid[][]) {
        if (r >= rl || c >= cl || r < 0 || c < 0) return;
        if (grid[r][c] == '0') {
            return;
        } else {
            grid[r][c] = '0';
            dfs(r + 1, c, rl, cl, grid);
            dfs(r - 1, c, rl, cl, grid);
            dfs(r, c + 1, rl, cl, grid);
            dfs(r, c - 1, rl, cl, grid);
        }
    }
}