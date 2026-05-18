class Solution {
    public int[] shuffle(int[] nums, int n) {
        int numsLength = n * 2;
        int[] result = new int[numsLength];
        int i = 0, j = 0, k = n;
        while (i < numsLength) {
            if (i % 2 == 0) {
                result[i] = nums[j];
                ++j;
            }
            else {
                result[i] = nums[k];
                ++k;
            }
            ++i;
        }
        return result;
    }
}