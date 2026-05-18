class Solution {
    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void sortColors(int[] nums) {
        int numsLength = nums.length;
        int left = 0;
        int right = numsLength - 1;
        int i = 0;
        while (i <= right) {
            if (nums[i] == 0) {
                swap(left, i, nums);
                left++;
                i++;
            }
            else if (nums[i] == 2) {
                swap(right, i, nums);
                right--;
            }
            else i++;
        }
    }
}