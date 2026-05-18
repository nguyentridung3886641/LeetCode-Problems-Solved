class Solution {
    public int longestPalindrome(String s) {
        int sLength = s.length();
        int[] freq = new int[58];
        int palindromeLength = 0;
        for (int i = 0; i < sLength; i++) {
            int index = s.charAt(i) - 'A';
            ++freq[index];
        }
        for (int i : freq) {
            palindromeLength += (i / 2) * 2;
        }
        if (palindromeLength < sLength) ++palindromeLength;
        return palindromeLength;
    }
}