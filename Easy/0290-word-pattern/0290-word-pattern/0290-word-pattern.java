import java.util.HashMap;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] sArray = s.split(" ");
        HashMap<Character, String> map = new HashMap<>();
        int sArrayLength = sArray.length;
        int patternLength = pattern.length();
        if (patternLength != sArrayLength) return false;
        for (int i = 0; i < sArrayLength; i++) {
            char charPattern = pattern.charAt(i);
            if (map.containsKey(charPattern)) {
                if (!map.get(charPattern).equals(sArray[i]))
                    return false;
            }
            else {
                if (map.containsValue(sArray[i]))
                    return false;
            }
            map.put(charPattern, sArray[i]);
        }
        return true;
    }
}