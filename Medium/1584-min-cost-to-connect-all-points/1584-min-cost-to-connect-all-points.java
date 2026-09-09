import java.util.Arrays;

class Solution {
    int[] parents;
    int[] size;
    int[][] edges;
    public int minCostConnectPoints(int[][] points) {
        int V = points.length;
        int E = V * (V - 1) / 2;
        
        if (V <= 1) {
            return 0;
        }

        parents = new int[V];
        size = new int[V];
        for (int i = 0; i < V; i++) {
            parents[i] = i;
            size[i] = 1;
        }

        edges = new int[E][3];
        int k = 0;
        for (int i = 0; i < V; i++) {
            for (int j = i + 1; j < V; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];

                int x2 = points[j][0];
                int y2 = points[j][1];

                edges[k][0] = i;
                edges[k][1] = j;
                edges[k][2] = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                k++;
            }
        }

        int edgesCount = 0;
        int minCost = 0;
        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));
        for (int[] edge : edges) {
            if (union(edge[0], edge[1])) {
                minCost += edge[2];
                edgesCount++;
            }

            if (edgesCount == V - 1) {
                return minCost;
            }
        }

        return -1;
    }

    public int find(int i) {
        if (parents[i] == i) {
            return i;
        }
        return parents[i] = find(parents[i]);
    }

    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return false;
        }

        if (size[rootX] < size[rootY]) {
            int temp = rootX;
            rootX = rootY;
            rootY = temp;
        }

        parents[rootY] = rootX;
        size[rootX] += size[rootY];

        return true;
    }
}