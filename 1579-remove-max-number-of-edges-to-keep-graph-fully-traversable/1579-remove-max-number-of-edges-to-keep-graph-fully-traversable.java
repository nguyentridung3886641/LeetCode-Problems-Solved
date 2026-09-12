class Solution {
    public class dsuOfAlice {
        private final int[] parents;
        private final int[] size;

        public dsuOfAlice(int n) {
            parents = new int[n];
            size = new int[n];

            for (int i = 1; i < n; i++) {
                parents[i] = i;
                size[i] = 1;
            }
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
            
            size[rootX] += size[rootY];
            parents[rootY] = rootX;
            
            return true;
        }
    }

    public class dsuOfBob {
        private final int[] parents;
        private final int[] size;

        public dsuOfBob(int n) {
            parents = new int[n];
            size = new int[n];

            for (int i = 1; i < n; i++) {
                parents[i] = i;
                size[i] = 1;
            }
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
            
            size[rootX] += size[rootY];
            parents[rootY] = rootX;
            
            return true;
        }
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        dsuOfAlice dsuOfAlice = new dsuOfAlice(n + 1);
        dsuOfBob dsuOfBob = new dsuOfBob(n + 1);

        int remainEdgesT3 = 0;
        int remainEdgesOfAlice = 0;
        int remainEdgesOfBob = 0;

        for (int[] edge : edges) {
            if (edge[0] == 1 || edge[0] == 2) {
                continue;
            }
            
            if (dsuOfBob.union(edge[1], edge[2]) && dsuOfAlice.union(edge[1], edge[2])) {
                ++remainEdgesT3;
            }
        }
        
        for (int[] edge : edges) {
            if (edge[0] == 1 && dsuOfAlice.union(edge[1], edge[2])) {
                ++remainEdgesOfAlice;
            }

            if (edge[0] == 2 && dsuOfBob.union(edge[1], edge[2])) {
                ++remainEdgesOfBob;
            }
        }
        
        if (remainEdgesOfAlice + remainEdgesT3 < n - 1 || remainEdgesOfBob + remainEdgesT3 < n - 1) {
            return -1;
        }
        
        return edges.length - (remainEdgesOfAlice + remainEdgesOfBob + remainEdgesT3);
    }
}