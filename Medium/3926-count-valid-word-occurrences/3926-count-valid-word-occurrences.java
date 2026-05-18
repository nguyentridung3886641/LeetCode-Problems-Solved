import java.util.*;

class Solution {
    public int[] countWordOccurrences(String[] chunks, String[] queries) {
        int[] res = new int[queries.length];
        StringBuilder sb = new StringBuilder();
        StringBuilder currentWord = new StringBuilder();
        HashMap<String, Integer> wordCountMap = new HashMap<>();
        for (String s : chunks) {
            sb.append(s);
        }
        int length = sb.length();
        for (int i = 0; i < length; i++) {
            char c = sb.charAt(i);
            if (Character.isLowerCase(c))
                currentWord.append(c);
            else if (c == '-') {
                if (isHyphenValid(sb, i))
                    currentWord.append(c);
                else 
                    saveCurrentWord(currentWord, wordCountMap);
            }
            else {
                saveCurrentWord(currentWord, wordCountMap);
            }
        }
        saveCurrentWord(currentWord, wordCountMap);

        for (int i = 0; i < queries.length; i++) {
            res[i] = wordCountMap.getOrDefault(queries[i], 0);
        }
        return res;
    }
    public boolean isHyphenValid(StringBuilder sb, int index) {
        if (index == 0) return false;
        else if (index == sb.length() - 1) return false;
        else {
            if (!Character.isLowerCase(sb.charAt(index - 1)) || !Character.isLowerCase(sb.charAt(index + 1)))
                return false;
        }
        return true;
    }
    public void saveCurrentWord(StringBuilder currentWord, HashMap<String, Integer> wordCountMap) {
        if (currentWord.length() > 0) {
            String word = currentWord.toString();
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            currentWord.setLength(0);
        }
    }
}