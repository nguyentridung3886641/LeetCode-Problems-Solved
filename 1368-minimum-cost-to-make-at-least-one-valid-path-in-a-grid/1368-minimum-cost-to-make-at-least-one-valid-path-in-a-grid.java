import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] minDist = new int[m][n];
        for (int[] row : minDist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        minDist[0][0] = 0;

        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{0, 0, 0});

        int[] dr = {0, 0, 0, 1, -1};
        int[] dc = {0, 1, -1, 0, 0};

        while (!dq.isEmpty()) {
            int[] curCell = dq.pollFirst();
            int r, c, d, nr, nc;

            r = curCell[0];
            c = curCell[1];
            d = curCell[2];

            if (d > minDist[r][c]) {
                continue;
            }

            if (r == m - 1 && c == n - 1) {
                return d;
            }

            for (int i = 1; i <= 4; i++) {
                nr = r + dr[i];
                nc = c + dc[i];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }

                int w = (grid[r][c] == i) ? 0 : 1;
                if (d + w < minDist[nr][nc]) {
                    minDist[nr][nc] = d + w;
                    if (w == 1) {
                        dq.addLast(new int[]{nr, nc, minDist[nr][nc]});
                    } else {
                        dq.addFirst(new int[]{nr, nc, minDist[nr][nc]});
                    }
                }
            }
        }
        return -1;
    }
}