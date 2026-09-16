import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;

        Deque<int[]> dq = new ArrayDeque<>();
        dq.addFirst(new int[]{0, 0, 0});

        int[] dr = {0, 0, -1, 1};
        int[] dc = {-1, 1, 0, 0};

        while (!dq.isEmpty()) {
            int[] curCell = dq.pollFirst();
            int r, c, d;

            r = curCell[0];
            c = curCell[1];
            d = curCell[2];

            if (r == m - 1 && c == n - 1) {
                return d;
            }

            if (d > dist[r][c]) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }

                int w = grid[nr][nc];
                if (w + d < dist[nr][nc]) {
                    dist[nr][nc] = w + d;

                    if (grid[nr][nc] == 1) {
                        dq.offerLast(new int[]{nr, nc, dist[nr][nc]});
                    } else {
                        dq.offerFirst(new int[]{nr, nc, dist[nr][nc]});
                    }
                }
            }
        }

        return - 1;
    }
}