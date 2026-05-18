class Solution {
    public int characterReplacement(String s, int k) {
        int sLength = s.length();
        int i = 0, j = 0, maxLen = 0;
        int[] freq = new int[26];
        ++freq[s.charAt(j) - 'A'];
        int maxFreq = 1;
        
        while (j < sLength) {
            int winLen = j - i + 1;
            maxFreq = Math.max(maxFreq, freq[s.charAt(j) - 'A']);

            if (winLen - maxFreq <= k) {
                maxLen = Math.max(maxLen, winLen);
                ++j;
                if (j < sLength)
                    ++freq[s.charAt(j) - 'A'];
            }

            else {
                --freq[s.charAt(i) - 'A'];
                ++i;
            }
        }
        return maxLen;
    }
}