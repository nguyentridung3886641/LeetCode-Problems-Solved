class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return false;
        }

        int target = 0;
        for (int i = 0; i < nums.length; i++) {
            target += nums[i];
        }

        if (target % 2 != 0) {
            return false;
        }

        target /= 2;

        boolean[][] dp = new boolean[n + 1][target + 1];
        dp[0][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }

            if (dp[i][target]) {
                return true;
            }
        }

        return false;
    }
}