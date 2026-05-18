class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int left = 0;
        int right = n - 1;
        int p = n - 1;

        while (left <= right) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                res[p] = nums[left] * nums[left];
                ++left;
                --p;
            }
            else {
                res[p] = nums[right] * nums[right];
                --right;
                --p;
            }
        }
        return res;
    }
} 