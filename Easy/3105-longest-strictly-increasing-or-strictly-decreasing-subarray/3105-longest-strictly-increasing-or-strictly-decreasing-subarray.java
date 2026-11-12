class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        boolean status = true;
        int maxLength = 1, curLength = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                if (status == false) {
                    curLength = 1;
                    status = true;
                }
                curLength++;
            } else if (nums[i] < nums[i - 1]) {
                if (status == true) {
                    curLength = 1;
                    status = false;
                }
                curLength++;
            } else {
                curLength = 1;
            }

            maxLength = Math.max(maxLength, curLength);
        }

        return maxLength;
    }
}