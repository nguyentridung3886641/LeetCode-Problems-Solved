class Solution {
    public int[] concatWithReverse(int[] nums) {
        int length = nums.length;
        int[] res = new int[length * 2];
        for (int i = 0; i < length; i++) {
            res[i] = nums[i];
        }
        for (int i = 0; i < length; i++) {
            res[length + i] = nums[length - i - 1];
        }
        return res;
    }
}