class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();

        HashSet<String> dict = new HashSet<>();
        for (String str : wordDict) {
            dict.add(str);
        }

        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            int j = (i - 20 >= 0) ? i - 20 : 0;
            for (; j < i; j++) {
                if (!dp[j]) {
                    continue;
                }

                if (dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}