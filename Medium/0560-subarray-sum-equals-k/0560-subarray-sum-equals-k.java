class Solution {
    public int subarraySum(int[] a, int k) {
        int ans = 0;
        int n = a.length;

        int[] pref = new int[n + 1];
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 1; i <= n; i++) {
            pref[i] = a[i - 1] + pref[i - 1];
            if (map.containsKey(pref[i] - k)) {
                ans += map.get(pref[i] - k);
            }
            map.put(pref[i], map.getOrDefault(pref[i], 0) + 1);
        }

        return ans;
    }
}