class Solution {
    int[] parents;
    int[] size;
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] inDegree = new int[n + 1];

        for (int[] edge : edges) {
            ++inDegree[edge[1]];
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 2) {
                ans = i;
                break;
            }
        }

        parents = new int[n + 1];
        size = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parents[i] = i;
            size[i] = 1;
        }

        if (ans == 0) {
            for (int[] edge : edges) {
                if (!union(edge[0], edge[1])) {
                    return edge;
                }
            }
        }

        int[] edge1 = null;
        int[] edge2 = null;
        for (int[] edge : edges) {
            if (edge[1] == ans && edge1 == null) {
                edge1 = edge;
                continue;
            }
            if (edge[1] == ans) {
                edge2 = edge;
                break;
            }
        }

        for (int[] edge : edges) {
            if (Arrays.equals(edge, edge2)) {
                continue;
            }

            if (!union(edge[0], edge[1])) {
                return edge1;
            }
        }

        return edge2;
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