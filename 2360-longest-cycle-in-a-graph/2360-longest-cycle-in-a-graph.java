class Solution {
    private int maxLength = -1;
    public int longestCycle(int[] edges) {
        int n = edges.length;
        int[][] status = new int[n][2];

        for (int i = 0; i < n; i++) {
            if (status[i][0] == 0) {
                dfs(i, 0, edges, status);
            }
        }
        return maxLength;
    }

    public void dfs(int node, int step, int[] edges, int[][] status) {
        if (status[node][0] == 2) {
            return;
        } else if (status[node][0] == 1) {
            maxLength = Math.max(maxLength, step - status[node][1] + 1);
        } else {
            if (edges[node] == -1) {
                status[node][0] = 2;
                return;
            }
            
            ++step;
            status[node][0] = 1;
            status[node][1] = step;
            dfs(edges[node], step, edges, status);

            status[node][0] = 2;
        }
    }
}