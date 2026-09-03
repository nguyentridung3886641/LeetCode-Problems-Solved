import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int freshOranges = 0, minutes = 0;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    ++freshOranges;
                }
            }
        }

        int[] dr = {-1, 1, 0 ,0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty() && freshOranges > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curCell = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nr = curCell[0] + dr[j];
                    int nc = curCell[1] + dc[j];

                    if (nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        queue.offer(new int[]{nr, nc});
                        --freshOranges;
                    }
                }
            }
            ++minutes;
        }
        return (freshOranges == 0) ? minutes : -1;
    }
}