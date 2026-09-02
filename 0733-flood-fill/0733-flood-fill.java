import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original = image[sr][sc];
        if (original == color) return image;
        int m = image.length, n = image[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        image[sr][sc] = color;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] curPixel = queue.poll();
            int r = curPixel[0];
            int c = curPixel[1];
            
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if ((nr >= 0 && nr < m && nc >= 0 && nc < n) && image[nr][nc] == original) {
                    image[nr][nc] = color;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
        return image;
    }
}