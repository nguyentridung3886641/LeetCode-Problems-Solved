class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Queue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> pairEntry : map.entrySet()) {
            int num = pairEntry.getKey();
            int freq = pairEntry.getValue();
            if (q.size() < k) {
                q.offer(new int[]{num, freq});
            }
            else if (q.size() >= k && q.peek()[1] < freq) {
                q.poll();
                q.offer(new int[]{num, freq});
            }
        }
        for (int i = 0; i < k; ++i) {
            res[i] = q.poll()[0];
        }
        return res;
    }
}