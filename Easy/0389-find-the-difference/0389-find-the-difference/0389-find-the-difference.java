class Solution {
    public char findTheDifference(String s, String t) {
        int charSum = 0;
        int sLength = s.length();
        int tLength = t.length();
        for (int i = 0; i < sLength; i++) {
            charSum += t.charAt(i);
            charSum -= s.charAt(i);
        }
        charSum += t.charAt(tLength - 1);
        return (char)charSum;
    }
}