import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        int[] answer = new int[n];

        Arrays.fill(answer, -1);

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] p : richer) {
            int rich = p[0];
            int poor = p[1];

            adj.get(poor).add(rich);
        }

        for (int i = 0; i < n; i++) {
            dfs(i, quiet, answer, adj);
        }

        return answer;
    }
    public static int dfs(int u, int[] quiet, int[] answer, List<List<Integer>> adj) {
        if (answer[u] != -1) {
            return answer[u];
        }

        answer[u] = u;

        for (int v : adj.get(u)) {
            int candidate = dfs(v, quiet, answer, adj);

            if (quiet[candidate] < quiet[answer[u]]) {
                answer[u] = candidate;
            }
        }

        return answer[u];
    }
}