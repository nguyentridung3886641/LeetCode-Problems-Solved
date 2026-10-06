class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0, close = 0, ans = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                ++open;
            } else {
                ++close;
            }

            if (close > open) {
                ++open;
                ++ans;
            }
        }

        ans += open - close;
        return ans;   
    }
}