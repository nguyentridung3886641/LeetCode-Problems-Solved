class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        
        int i = 0, j = 0;
        int maxLength = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        while (j < n) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)) + 1);
            }
            map.put(s.charAt(j), j);
            maxLength = Math.max(maxLength, j - i + 1);
            j++;
        }
        return maxLength;
    }
}