class Solution {
    public boolean uniformArray(int[] nums1) {
        if (nums1.length == 1) return true;
        int minimum = Integer.MAX_VALUE;
        for (int i = 0; i < nums1.length; i++) {
            minimum = Math.min(minimum, nums1[i]);
        }

        if (minimum % 2 == 1)
            return true;

        for (int num : nums1) {
            if (num % 2 == 1)
                return false;
        }

        return true;
    }
}