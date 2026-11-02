class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int top = -1;

        int[] stack = new int[n];
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            while (top >= 0 && temperatures[stack[top]] < temperatures[i]) {
                int idx = stack[top--];
                ans[idx] = i - idx;
            }

            stack[++top] = i;
        }

        return ans;
    }
}