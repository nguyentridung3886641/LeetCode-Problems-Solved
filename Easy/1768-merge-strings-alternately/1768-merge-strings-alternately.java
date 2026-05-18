class Solution {
    public String mergeAlternately(String word1, String word2) {
        int wordLength1 = word1.length();
        int wordLength2 = word2.length();
        int maxLength = (wordLength1 < wordLength2) ? wordLength2 : wordLength1;
        StringBuilder res = new StringBuilder(wordLength1 + wordLength2);
        for (int i = 0; i < wordLength1 || i < wordLength2; i++) {
                if (i < wordLength1) res.append(word1.charAt(i));
                if (i < wordLength2) res.append(word2.charAt(i));
            }
        return res.toString();
    }
}