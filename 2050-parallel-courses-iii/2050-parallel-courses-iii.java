class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        int res = 0;
        int[] inDegree = new int[n + 1];
        int[] dist = new int[n + 1];
        List<List<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < relations.length; i++) {
            int prevCourse = relations[i][0];
            int nextCourse = relations[i][1];

            adj.get(prevCourse).add(nextCourse);
            ++inDegree[nextCourse];
        }

        Queue<Integer> queue = new ArrayDeque<>();
        
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
                dist[i] = time[i - 1];
            }
        }

        while (!queue.isEmpty()) {
            int curCourse = queue.poll();
            for (int nextCourse : adj.get(curCourse)) {
                --inDegree[nextCourse];
                dist[nextCourse] = Math.max(dist[nextCourse], dist[curCourse] + time[nextCourse - 1]);
                if (inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }
        
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, dist[i]);
        }
        return res;
    }
}