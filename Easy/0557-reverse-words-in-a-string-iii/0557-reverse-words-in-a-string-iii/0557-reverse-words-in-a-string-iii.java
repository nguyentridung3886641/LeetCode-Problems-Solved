class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder res = new StringBuilder();
        int wordsLength = words.length;
        for (int i = 0; i < wordsLength; i++) {
            StringBuilder convert = new StringBuilder(words[i]);
            res.append(convert.reverse());
            if (i < wordsLength - 1)
                res.append(" ");
        }
        return res.toString();
    }
}