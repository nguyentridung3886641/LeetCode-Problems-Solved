import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] res = new int[length];
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            if (stack.isEmpty()) stack.add(new int[]{i, temperatures[i]});
            else{
                while (!stack.isEmpty() && stack.peek()[1] < temperatures[i]) {
                    int idx = stack.peek()[0];
                    int val = i - idx;
                    stack.pop();
                    res[idx] = val;
                }
                stack.add(new int[]{i, temperatures[i]});
            }
        }
        return res;
    }
}