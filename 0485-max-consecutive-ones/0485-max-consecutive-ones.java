class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int numsLength = nums.length;
        int count = 0, res = 0;
        for (int i = 0; i < numsLength; i++) {
            if (nums[i] == 1)
                ++count;
            else
                count = 0;
            if (count > res)
                res = count;
        }
        return res;
    }
}