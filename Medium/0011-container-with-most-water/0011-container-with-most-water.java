class Solution {
    public int maxArea(int[] height) {
        int length = height.length;
        int maxVol = 0;
        int i = 0, j = length - 1;

        while (i < j) {
            int min = Math.min(height[i], height[j]);
            maxVol = Math.max(maxVol, min * (j - i));

            while (i < j && height[i] <= min) i++;
            while (i < j && height[j] <= min) j--;
        }
        return maxVol;
    }
}
