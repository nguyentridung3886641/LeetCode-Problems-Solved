class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return false;
        }

        int target = 0;
        for (int i = 0; i < n; i++) {
            target += nums[i];
        }

        if (target % 2 != 0) {
            return false;
        }

        target /= 2;

        byte[][] mem = new byte[n][target + 1];

        return dp(nums, mem, n, target, 0);
    }

    public boolean dp(int[] nums, byte[][] mem, int n, int target, int idx) {
        if (target == 0) return true;
        if (idx >= n || target < 0) return false;
        
        if (mem[idx][target] != 0) {
            return mem[idx][target] == 1;
        }

        boolean res = dp(nums, mem, n, target - nums[idx], idx + 1)
                   || dp(nums, mem, n, target, idx + 1);

        mem[idx][target] = (byte) (res ? 1 : -1);

        return res;
    }
}