import java.util.Arrays;

class Solution {
    public int missingNumber(int[] nums) {
        int numsLength = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < numsLength - 1; i++) {
            if (nums[i + 1] - nums[i] > 1)
                return nums[i] + 1;
        }
        if (nums[numsLength - 1] == numsLength)
            return 0;
        else return nums[numsLength - 1] + 1;
    }
}