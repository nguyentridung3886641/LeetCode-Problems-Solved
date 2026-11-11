class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length, peek = -1;
        int[] stack = new int[n];
        long maxArea = 0;

        for (int i = 0; i <= n; i++) {
            int curHeight = (i == n) ? 0 : heights[i];

            while (peek >= 0 && heights[stack[peek]] >= curHeight) {
                int h = heights[stack[peek--]];
                int w = (peek == -1) ? i : i - stack[peek] - 1;

                maxArea = Math.max(maxArea, (long) h * w);
            }

            stack[++peek] = i;
        }

        return (int) maxArea;
    }
}