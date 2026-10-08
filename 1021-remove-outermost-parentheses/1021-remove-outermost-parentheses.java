class Solution {
    public String removeOuterParentheses(String s) {
        int remain = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                ++remain;
                if (remain >= 2) {
                    sb.append(c);
                }                
            } else {
                if (remain >= 2) {
                    sb.append(c);
                }
                --remain;
            }
        }

        return sb.toString();
    }
}