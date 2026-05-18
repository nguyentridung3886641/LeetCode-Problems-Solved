class Solution {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        int sLength = s.length();
        for (int i = 0; i < sLength; i++) {
            int index = s.charAt(i) - 'a';
            ++freq[index];
        }
        for (int i = 0; i < sLength; ++i) {
            int index = s.charAt(i) - 'a';
            if (freq[index] == 1) return i;
        }
        return -1;
    }
}