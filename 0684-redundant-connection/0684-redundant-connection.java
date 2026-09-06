class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parents = new int[n + 1];
        int[] size = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            int x = edges[i][0];
            int y = edges[i][1];

            if (!union(x, y, parents, size)) {
                return edges[i];
            }
        }
        return new int[0];
    }

    public static int find(int i, int[] parents) {
        if (parents[i] == i) {
            return i;
        }
        return parents[i] = find(parents[i], parents);
    }

    public static boolean union(int x, int y, int[] parents, int[] size) {
        int rootX = find(x, parents);
        int rootY = find(y, parents);

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