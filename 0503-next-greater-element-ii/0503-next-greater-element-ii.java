class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length, peek = -1, maxVal = Integer.MIN_VALUE;
        int[] res = new int[n];
        int[] stack = new int[n];

        for (int i = 0; i < 2 * n; i++) {
            int idx = i % n;
            maxVal = Math.max(maxVal, nums[idx]);

            if (i >= n && nums[idx] == maxVal) {
                res[idx] = -1;
            }

            while (peek >= 0 && nums[stack[peek]] < nums[idx]) {
                res[stack[peek--]] = nums[idx];
            }

            if (i < n) {
                stack[++peek] = idx;
            }
        }

        return res;
    }
}