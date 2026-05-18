class Solution {
    public String longestCommonPrefix(String[] strs) {
        int arrLength = strs.length;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < arrLength; j++) {
                if (i == strs[j].length() || c != strs[j].charAt(i))
                    return res.toString();
            }
            res.append(c);
        }
        return res.toString();
    }
}