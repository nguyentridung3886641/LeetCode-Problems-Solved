class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] minSufix = new int[n];
        minSufix[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            minSufix[i] = Math.min(minSufix[i + 1], nums[i]);
        }

        int maxPrefix = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxPrefix = Math.max(maxPrefix, nums[i]);
            if (maxPrefix - minSufix[i] <= k) {
                return i;
            }
        }
        return -1;
    }
}