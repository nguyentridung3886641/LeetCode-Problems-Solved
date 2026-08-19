class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0, numsLength = nums.length;
        if (numsLength == 1) return true;
        if (nums[0] == 0) return false;
        
        for (int i = 0; i < numsLength; i++) {
            if (maxReach >= numsLength - 1) return true;
            if (i > maxReach) return false;
            
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return false;
    }
}