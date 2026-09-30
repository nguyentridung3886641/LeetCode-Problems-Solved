class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        
        int i = 0, j = 0;
        int[] mem = new int[90];
        int maxLength = 0, curLength = 0;

        while (j < n) {
            mem[s.charAt(j) - ' ']++;
            if (mem[s.charAt(j) - ' '] > 1) {
                while (s.charAt(i) != s.charAt(j)) {
                    mem[s.charAt(i) - ' ']--;
                    i++;
                }
                mem[s.charAt(i) - ' ']--;
                i++;
                curLength = j - i;
            }
            
            j++;
            curLength++;
            
            maxLength = Math.max(curLength, maxLength);
        }
        return maxLength;
    }
}