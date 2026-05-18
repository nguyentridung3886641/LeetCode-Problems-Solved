class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int rowLimit = image.length - 1, colLimit = image[0].length - 1;
        int oldColor = image[sr][sc];
        if (oldColor == color) return image;
        dfs(sr, sc, colLimit, rowLimit, oldColor, color, image);
        return image;
    }
    public void dfs(int row, int col, int colLimit, int rowLimit, int oldColor, int color, int[][] image) {
        if (row > rowLimit || col > colLimit || col < 0 || row < 0) return;
        if (image[row][col] != oldColor) return;
        else {
            image[row][col] = color;
        }
        dfs(row + 1, col, colLimit, rowLimit, oldColor, color, image);
        dfs(row - 1, col, colLimit, rowLimit, oldColor, color, image);
        dfs(row, col + 1, colLimit, rowLimit, oldColor, color, image);
        dfs(row, col - 1, colLimit, rowLimit, oldColor, color, image);
    }
}