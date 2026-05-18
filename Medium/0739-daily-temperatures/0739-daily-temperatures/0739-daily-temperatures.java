class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        int[] stack = new int[n]; // Mảng thay thế cho Stack
        int top = -1; // Con trỏ quản lý đỉnh stack

        for (int i = 0; i < n; i++) {
            // Kiểm tra stack không trống và nhiệt độ hiện tại ấm hơn
            while (top > -1 && temperatures[i] > temperatures[stack[top]]) {
                int prevIndex = stack[top--]; // pop()
                res[prevIndex] = i - prevIndex;
            }
            stack[++top] = i; // push()
        }
        return res;
    }
}