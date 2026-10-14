class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        int n = s.length();

        if (n == 1) return 1;

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }

            int x = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');
            if (x >= 10 && x <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}