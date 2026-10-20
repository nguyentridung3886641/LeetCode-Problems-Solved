class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int closestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < n; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int currSum = nums[left] + nums[right] + nums[i];

                if (currSum == target) return currSum;

                closestSum = (Math.abs(currSum - target) < Math.abs(closestSum - target)) ? currSum
                                                                                          : closestSum;

                if (currSum < target) {
                    ++left;
                } else {
                    --right;
                }
            }
        }

        return closestSum;
    }
}