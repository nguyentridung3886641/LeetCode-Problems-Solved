class Solution {
    public int maxDepth(String s) {
        int maxDepth = 0, curDepth = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                ++curDepth;
            }
            if (s.charAt(i) == ')') {
                --curDepth;
            }
            maxDepth = Math.max(maxDepth, curDepth);
        }
        return maxDepth;
    }
}