class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        int[] outDegree = new int[graph.length];
        int nodes = graph.length;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < nodes; i++) {
            int starting = i;
            for (int j = 0; j < graph[i].length; j++) {
                int destination = graph[i][j];
                adj.get(destination).add(starting);
                ++outDegree[starting];
            }
        }

        boolean[] isSafe = new boolean[nodes];
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < nodes; i++) {
            if (outDegree[i] == 0) {
                queue.offer(i);
            }
        }

        Arrays.fill(isSafe, false);
        while (!queue.isEmpty()) {
            int safeNode = queue.poll();
            isSafe[safeNode] = true;

            for (int starting : adj.get(safeNode)) {
                --outDegree[starting];
                if (outDegree[starting] == 0) {
                    queue.offer(starting); 
                }
            }
        }
        
        for (int i = 0; i < nodes; i++) {
            if (isSafe[i] == true) {
                res.add(i);
            }
        }

        return res;
    }
}