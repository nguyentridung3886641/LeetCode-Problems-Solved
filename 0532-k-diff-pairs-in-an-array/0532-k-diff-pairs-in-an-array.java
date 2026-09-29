class Solution {
    public int findPairs(int[] a, int k) {
        int n = a.length;
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        if (k > 0) {
            for (int i = 0; i < n; i++) {
                map.putIfAbsent(a[i], 1);
            }

            for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
                if (map.containsKey(pair.getKey() + k)) {
                    ++ans;
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                map.put(a[i], map.getOrDefault(a[i], 0) + 1);
            }

            for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
                if (map.get(pair.getKey() + k) >= 2) {
                    ++ans;
                }
            }
        }
        return ans;
    }
}