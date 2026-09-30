class Solution {
    public List<Boolean> kidsWithCandies(int[] a, int extraCandies) {
        int greatest = 0;
        int n = a.length;
        for (int i = 0; i < n; i++) {
            greatest = Math.max(greatest, a[i]);
        }

        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (a[i] + extraCandies >= greatest) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }
        return ans;
    }
}