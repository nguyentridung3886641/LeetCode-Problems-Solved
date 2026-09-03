class Solution {
    public boolean uniformArray(int[] nums1) {
        if (nums1.length == 1) return true;
        int minOdd = Integer.MAX_VALUE, minEven = Integer.MAX_VALUE;
        int minOddCount = 0, evenCount = 0, oddCount = 0;

        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] % 2 != 0) {
                minOdd = Math.min(minOdd, nums1[i]);
                ++oddCount;
            } else {
                minEven = Math.min(minEven, nums1[i]);
                ++evenCount;
            }
        }

        if (oddCount == 0 || evenCount == 0) return true;

        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] == minOdd) {
                ++minOddCount;
            }
        }

        if (minOddCount > 1) {
            return true;
        } else if (minEven > minOdd) {
            return true;
        } else {
            return false;
        }
    }
}