class Solution {
    public void moveZeroes(int[] nums) {
        int numsLength = nums.length;
        if (numsLength == 1) return;
        for (int i = 0; i < numsLength - 1; i++) {
            while (nums[i] != 0 && i < numsLength - 2)
                ++i;
            int j = i + 1, temp = 0;
            while (nums[j] == 0 && j < numsLength - 1)
                ++j;
            if (nums[i] == 0 && nums[j] != 0) {
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
    }
}