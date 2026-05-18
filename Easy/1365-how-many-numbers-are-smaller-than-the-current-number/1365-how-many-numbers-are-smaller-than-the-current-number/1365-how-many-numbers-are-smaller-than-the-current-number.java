class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int numsLength = nums.length;
        int[] freq = new int[101];
        int[] res = new int[numsLength];
        for (int i = 0; i < numsLength; i++) {
            ++freq[nums[i]];
        }
        for (int i = 1; i <= 100; i++) {
            freq[i] += freq[i - 1];
        }
        for (int i = 0; i < numsLength; i++) {
            if (nums[i] == 0)
                res[i] = 0;
            else 
                res[i] = freq[nums[i] - 1];
        }
        return res;
    }
}