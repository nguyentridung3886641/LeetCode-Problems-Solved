import java.util.*;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int numsLength = nums.length;
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < numsLength; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0)
                nums[index] *= -1;
        }
        for (int i = 0; i < numsLength; i++) {
            if (nums[i] > 0)
                res.add(i + 1);
        }
        return res;
    }
}