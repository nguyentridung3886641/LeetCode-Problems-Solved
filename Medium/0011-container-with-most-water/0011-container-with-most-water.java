class Solution {
    public int maxArea(int[] height) {
        int length = height.length;
        int maxVol = 0;
        int i = 0, j = length - 1;

        while (i < j) {
            maxVol = Math.max(maxVol ,(j - i) * Math.min(height[i], height[j]));
            if (height[i] < height[j]) {
                i++;
            }
            else {
                j--;
            }
        }
        return maxVol;
    }
}