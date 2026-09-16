import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    int[] dist;
    List<List<int[]>> adjList;
    PriorityQueue<int[]> pq;
    public int networkDelayTime(int[][] times, int n, int k) {
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        
        adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : times) {
            int u, v, w;

            u = edge[0];
            v = edge[1];
            w = edge[2];

            adjList.get(u).add(new int[]{v, w});
        }

        pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[]{k, 0});
        
        while (!pq.isEmpty()) {
            int[] curNode = pq.poll();
            int u = curNode[0], d = curNode[1];

            if (d > dist[u]) {
                continue;
            }

            for (int[] edge : adjList.get(u)) {
                int v, w;

                v = edge[0];
                w = edge[1];

                if (w + dist[u] < dist[v]) {
                    dist[v] = w + d;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }
        
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            
            if (res < dist[i]) {
                res = dist[i];
            }
        }
        return res;
    }
}