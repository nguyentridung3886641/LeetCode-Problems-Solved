class Solution {
    static int provinces;
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        provinces = n;
        int[] parents = new int[n];
        int[] size = new int[n];

        for (int i = 0; i < n; i++) {
            parents[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    union(i, j, parents, size);
                }
            }
        }

        return provinces;
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
        --provinces;

        return true;
    }
}