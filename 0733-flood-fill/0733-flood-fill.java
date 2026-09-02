class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original = image[sr][sc];
        if (original == color) return image;

        int rowLimit = image.length - 1, colLimit = image[0].length - 1;
        dfs(sr, sc, original, color, colLimit, rowLimit, image);
        
        return image;
    }
    public static void dfs(int row, int column, int original, int color, int colLimit, int rowLimit, int image[][]) {
        if (row > rowLimit || column > colLimit || row < 0 || column < 0) return;
        if (image[row][column] != original) {
            return;
        } else {
            image[row][column] = color;
        }
        dfs(row - 1, column, original, color, colLimit, rowLimit, image);
        dfs(row + 1, column, original, color, colLimit, rowLimit, image);
        dfs(row, column - 1, original, color, colLimit, rowLimit, image);
        dfs(row, column + 1, original, color, colLimit, rowLimit, image);
    }
}