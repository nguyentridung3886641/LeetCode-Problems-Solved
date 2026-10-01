class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int curRem = 0, ans = 0;
        int[] count = new int[k];
        count[0] = 1;

        for (int i = 0; i < n; i++) {
            curRem = ((curRem + nums[i] % k) + k) % k;
            ans += count[curRem];
            count[curRem]++;
        }

        return ans;
    }
}