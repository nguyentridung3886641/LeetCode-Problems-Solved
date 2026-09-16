class Solution {
    class Pair {
        int node;
        double prob;

        public Pair(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }

        public int getNode() { return this.node; }
        public double getProb() { return this.prob; }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double[] probability = new double[n];
        Arrays.fill(probability, -1);
        probability[start_node] = 1;

        List<List<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u, v;
            double w;

            u = edges[i][0];
            v = edges[i][1];
            w = succProb[i];

            adjList.get(u).add(new Pair(v, w));
            adjList.get(v).add(new Pair(u, w));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder((a, b) -> Double.compare(a.getProb(), b.getProb())));
        pq.offer(new Pair(start_node, 1));

        while (!pq.isEmpty()) {
            Pair curNode = pq.poll();
            int u = curNode.getNode();
            double p = curNode.getProb();

            if (u == end_node) {
                return p;
            }

            if (p < probability[u]) {
                continue;
            }

            for (Pair pair : adjList.get(u)) {
                int v = pair.getNode();
                double w = pair.getProb();

                if (p * w > probability[v]) {
                    probability[v] = p * w;
                    pq.offer(new Pair(v, probability[v]));
                }
            }
        }
        return 0;
    }
}