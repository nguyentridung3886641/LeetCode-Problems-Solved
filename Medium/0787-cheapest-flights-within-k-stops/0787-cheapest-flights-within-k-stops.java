import java.util.Arrays;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;

        for (int i = 1; i <= k + 1; i++) {
            boolean hasChanged = false;
            int[] tempCost = Arrays.copyOf(cost, n);

            for (int[] flight : flights) {
                int u, v, w;

                u = flight[0];
                v = flight[1];
                w = flight[2];

                if (cost[u] != Integer.MAX_VALUE && cost[u] + w < tempCost[v]) {
                    tempCost[v] = cost[u] + w;
                    hasChanged = true;
                }
            }

            cost = tempCost;
            if (!hasChanged) {
                break;
            }
        }

        return (cost[dst] != Integer.MAX_VALUE) ? cost[dst] : -1;
    }
}