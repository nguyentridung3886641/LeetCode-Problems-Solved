class Solution {
    public boolean check(int[] nums) {
        int count = 0, numsLength = nums.length;
        for (int i = 0; i < numsLength; i++) {
            if (nums[(i + 1) % numsLength] < nums[i]) {
                ++count;
            }
        }
        return (count > 1) ? false : true;
    }
}