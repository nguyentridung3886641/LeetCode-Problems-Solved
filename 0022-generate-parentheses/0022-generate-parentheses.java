class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        char[] path = new char[2 * n];

        backtrack(0, 0, n, path, ans);
        return ans;
    }
    public void backtrack(int open, int close, int n, char[] path, List<String> ans) {
        if (open == n && close == n) {
            ans.add(new String(path));
            return;
        }

        if (open < n) {
            path[open + close] = '(';
            backtrack(open + 1, close, n, path, ans);
        }

        if (close < open) {
            path[open + close] = ')';
            backtrack(open, close + 1, n, path, ans);
        }
    }
}