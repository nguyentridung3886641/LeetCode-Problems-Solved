import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;

        int[][] effort = new int[row][col];
        for (int[] i : effort) {
            Arrays.fill(i, Integer.MAX_VALUE);
        }
        effort[0][0] = 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        queue.offer(new int[]{0, 0, 0});

        int[][] direction = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] curPos = queue.poll();
            int r = curPos[1];
            int c = curPos[2];

            if (r == row - 1 && c == col - 1) {
                return effort[r][c];
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + direction[i][0];
                int nc = c + direction[i][1];

                if (nr >= 0 && nc >= 0 && nr < row && nc < col) {
                    int stepDiff = Math.abs(heights[nr][nc] - heights[r][c]);
                    int nextEffort = Math.max(effort[r][c], stepDiff);

                    if (nextEffort < effort[nr][nc]) {
                        effort[nr][nc] = nextEffort;
                        queue.offer(new int[]{nextEffort, nr, nc});
                    }
                }
            }
        }
        return 0;
    }
}