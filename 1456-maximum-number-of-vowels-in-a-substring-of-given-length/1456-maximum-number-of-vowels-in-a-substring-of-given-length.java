class Solution {
    public int maxVowels(String s, int k) {
        int length = s.length();
        int count = 0;
        int max = 0;
        for (int i = 0; i < length; i++) {
            if (isVowel(s.charAt(i))) count++;
            if (i >= k - 1) {
            max = Math.max(max, count);
                if (isVowel(s.charAt(i - k + 1))) {
                count--;
                }
            }
        }
        return max;
    }
    public boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');     
    }
}