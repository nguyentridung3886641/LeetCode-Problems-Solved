class Solution {
    public int jump(int[] nums) {
        int numsLength = nums.length;
        if (numsLength == 1) return 0;
        
        int prevJumpReach = 0, maxReach = 0, step = 0;
        for (int i = 0; i < numsLength - 1; i++) {
            if (i > prevJumpReach) {
                ++step;
                prevJumpReach = maxReach;
            }

            maxReach = Math.max(maxReach, nums[i] + i);
            if (maxReach >= numsLength - 1) {
                return step + 1;
            }
        }
        return step;
    }
}