import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean isValid(String s) {
        int sLength = s.length();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < sLength; i++) {
            char charS = s.charAt(i);
            if (charS == '(' || charS == '[' || charS == '{') {
                stack.push(charS);
            }
            else {
                if (stack.isEmpty())
                    return false;

                if (charS == ')') {
                    if (stack.pop() != '(')
                        return false;
                }
                else if (charS == ']') {
                    if (stack.pop() != '[')
                        return false;
                }
                else if (charS == '}') {
                    if (stack.pop() != '{')
                        return false;
                }
            }
        }
        return stack.isEmpty(); 
    }
}