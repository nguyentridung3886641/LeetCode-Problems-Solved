import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int sLength = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int r = 0, l = 0, max = 0;
        while (r < sLength) {
            char charS = s.charAt(r);
            if (map.containsKey(charS))
                l = Math.max(l, map.get(charS) + 1);
            max = Math.max(max, r - l + 1);
            map.put(charS, r);
            ++r;
        }
        return max;
    }
}