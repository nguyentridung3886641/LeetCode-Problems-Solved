class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        if (matrix == null || m == 0 || n == 0) {
            return 0;
        }
        
        int[] heights = new int[n];
        int[] stack = new int[n];

        int ans = 0;

        for (int i = 0; i < m; i++) {
            int peek = -1;

            for (int j = 0; j <= n; j++) {
                int curHeight = 0;

                if (j < n) {
                    heights[j] = (matrix[i][j] == '1') ? heights[j] + 1 : 0;
                    curHeight = heights[j];
                }
                
                while (peek >= 0 && heights[stack[peek]] >= curHeight) {
                    int h = heights[stack[peek--]];
                    int w = (peek == -1) ? j : j - stack[peek] - 1;

                    ans = Math.max(ans, h * w);
                }

                stack[++peek] = j;
            }
        }

        return ans;
    }
}