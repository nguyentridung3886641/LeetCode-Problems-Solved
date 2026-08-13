class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int numsLength = nums.length;
        if (numsLength <= 1 || k == 0) return false;
        HashSet<Integer> set = new HashSet<>();
        set.add(nums[0]);

        int i = 0, j = 1;
        while (j < numsLength) {
            int winSize = Math.abs(i - j);
            if (winSize > k) {
                set.remove(nums[i]);
                ++i;
            }
            if (set.contains(nums[j]))
                return true;
            set.add(nums[j]);
            ++j;
        }
        return false;
    }
}