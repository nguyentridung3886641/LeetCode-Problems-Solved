import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        int sr = -1, sc = -1;
        int count = 0;

        int[][] id = new int[m][n];
        for (int[] row : id) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (classroom[i].charAt(j) == 'S') {
                    sr = i;
                    sc = j;
                }
                if (classroom[i].charAt(j) == 'L') {
                    id[i][j] = count++;
                }
            }
        }

        int masks = 1 << count;
        int fullMask = masks - 1;

        int[][][] best = new int[m][n][masks];
        for (int[][] layer : best) {
            for (int[] row : layer) {
                Arrays.fill(row, -1);
            }
        }

        class State {
            int r, c, mask, e, steps;

            State(int r, int c, int mask, int e, int steps) {
                this.r = r;
                this.c = c;
                this.mask = mask;
                this.e = e;
                this.steps = steps;
            }
        }

        Queue<State> queue = new LinkedList<>();
        queue.add(new State(sr, sc, 0, energy, 0));
        best[sr][sc][0] = energy;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            State cur = queue.poll();
            int r = cur.r;
            int c = cur.c;
            int mask = cur.mask;
            int e = cur.e;
            int steps = cur.steps;

            if (mask == fullMask)
                return steps;

            if (e == 0)
                continue;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nc < 0 || nr >= m || nc >= n)
                    continue;
                
                if (classroom[nr].charAt(nc) == 'X')
                    continue;

                int newE = e - 1;
                int newMask = mask;

                if (classroom[nr].charAt(nc) == 'L')
                    newMask |= (1 << id[nr][nc]);

                if (classroom[nr].charAt(nc) == 'R')
                    newE = energy;

                if (newE <= best[nr][nc][newMask])
                    continue;

                best[nr][nc][newMask] = newE;

                queue.add(new State(nr, nc, newMask, newE, steps + 1));
            }
        }
        return - 1;
    }
}