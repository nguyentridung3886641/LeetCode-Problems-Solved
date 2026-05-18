class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int sLength = sChars.length;
        int tLength = tChars.length;
        if (sLength != tLength) return false;
        int[] freq = new int[26];
        for (int i = 0; i < sChars.length; i++) {
            freq[sChars[i] - 'a']++;
            freq[tChars[i] - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) return false;
        }
        return true;
    }
}