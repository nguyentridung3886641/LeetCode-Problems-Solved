import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int numsLength = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < numsLength - 1; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = numsLength - 1;

            while (left < right) {
                int total = nums[i] + nums[left] + nums[right];

                if (total < 0) ++left;

                else if (total > 0) --right;

                else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1]) ++left;
                    while (right > left && nums[right] == nums[right -1]) --right;
                    
                    ++left;
                    --right;
                }
            }
        }
        return res;
    }
}