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

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = target; j >= nums[i - 1]; j--) {
                dp[j] = dp[j] || dp[j - nums[i - 1]];
            }

            if (dp[target]) {
                return true;
            }
        }

        return false;    
    }
}