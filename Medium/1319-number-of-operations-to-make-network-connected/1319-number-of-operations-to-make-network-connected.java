    class Solution {
        int[] parents;
        int[] size;
        int components;
        public int makeConnected(int n, int[][] connections) {
            int cables = connections.length;
            if (cables < n - 1) {
                return -1;
            }
            parents = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
                size[i] = 1;
            }

            for (int[] pc : connections) {
                union(pc[0], pc[1]);
            }

            components = 0;
            for (int i = 0; i < n; i++) {
                if (parents[i] == i) {
                    components++;
                }
            }
            return components - 1;
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
            --components;

            return true;
        }
    }