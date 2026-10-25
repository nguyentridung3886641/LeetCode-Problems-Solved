class Solution {
    public int longestOnes(int[] nums, int k) {
        int ans = 0, onCount = 0;
        int n = nums.length;

        int j = 0;
        for (int i = 0; i < n; i++) {
            int winLen = i - j + 1;

            if (nums[i] == 1) ++onCount;

            while (winLen - onCount > k) {
                if (nums[j] == 1) --onCount;

                ++j;
                --winLen;
            }

            ans = Math.max(ans, winLen);
        }

        return ans;
    }
}