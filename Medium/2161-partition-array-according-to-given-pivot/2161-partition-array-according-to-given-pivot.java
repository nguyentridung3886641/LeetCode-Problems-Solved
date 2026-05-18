class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int numsLength = nums.length;
        int[] res = new int[numsLength];
        Arrays.fill(res, pivot);
        int left = 0;
        for (int i = 0; i < numsLength; i++) {
            if (nums[i] < pivot) {
                res[left++] = nums[i];
            }
        }
        int right = numsLength - 1;
        for (int i = numsLength - 1; i >= 0; i--) {
            if (nums[i] > pivot) {
                res[right--] = nums[i];
            }
        }
    return res;
    }
}