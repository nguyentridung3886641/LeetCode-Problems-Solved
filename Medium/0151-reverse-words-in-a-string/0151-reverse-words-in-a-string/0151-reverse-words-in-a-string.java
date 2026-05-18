class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        int sLength = s.length();
        StringBuilder word = new StringBuilder();
        StringBuilder res = new StringBuilder();
        for (int i = sLength - 1; i >= 0; i--) {
            char charS = s.charAt(i);
            if (charS != ' ')
                word.append(charS);
            if (charS == ' ' || i == 0) {
                word.reverse();
                res.append(word);
                word.setLength(0);
                if (i > 0 && s.charAt(i - 1) != ' ')
                    res.append(' ');
            }
        }
        return res.toString();
    }
}