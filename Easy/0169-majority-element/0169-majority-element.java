import java.util.Arrays;

class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int numsLength = nums.length, res = 0, mostAppear = 0;
        
        if (numsLength == 1) return nums[0];

        for (int i = 0; i < numsLength; i++) {
            int j = i + 1, count = 1;
            while (j < numsLength && nums[i] == nums[j]) {
                count++;
                j++;
            }
            if (mostAppear < count) {
                mostAppear = count;
                res = nums[i];
            }
            i = j - 1;
        }
        return res;
    }
}