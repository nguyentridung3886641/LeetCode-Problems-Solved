class Solution {
    public void moveZeroes(int[] nums) {
        int lastNonZeroIndex = 0, cur = 0;
        int numsLength = nums.length;
        while (cur < numsLength) {
            if (nums[cur] != 0) {
                int temp = nums[cur];
                nums[cur] = nums[lastNonZeroIndex];
                nums[lastNonZeroIndex] = temp;
                ++lastNonZeroIndex;
            }
            ++cur;
        }
    }
}