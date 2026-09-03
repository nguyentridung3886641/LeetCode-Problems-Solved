class Solution {
    public boolean uniformArray(int[] nums1) {
        if (nums1.length == 1) return true;

        int minimum = Integer.MAX_VALUE;
        boolean hasOdd = false;

        for (int i = 0; i < nums1.length; i++) {
            minimum = Math.min(minimum, nums1[i]);
            if (nums1[i] % 2 != 0) {
                hasOdd = true;
            }
        }

        if (minimum % 2 != 0) {
            return true;
        } else if (hasOdd == true) {
            return false;
        }

        return true;
    }
}