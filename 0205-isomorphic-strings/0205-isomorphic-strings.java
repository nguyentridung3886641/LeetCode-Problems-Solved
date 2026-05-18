import java.util.HashMap;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        int sLength = s.length();
        HashMap<Character, Character> wordsReplace = new HashMap<>();
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sLength; i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
    
            if (!wordsReplace.containsKey(charS)) {
                if (wordsReplace.containsValue(charT)) return false;
                    wordsReplace.put(charS, charT);
            }
        }
        for (int i = 0; i < sLength; i++) {
            if (wordsReplace.containsKey(sb.charAt(i)))
                sb.setCharAt(i, wordsReplace.get(sb.charAt(i)));
        }
        if (sb.toString().equals(t)) return true;
        return false;
    }
}