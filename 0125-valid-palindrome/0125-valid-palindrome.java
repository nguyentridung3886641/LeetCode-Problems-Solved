class Solution {
    public boolean isPalindrome(String s) {
        int sLength = s.length();
        int left = 0, right = sLength - 1;
        while (left <= right) {
            while (left < right && Character.isLetterOrDigit(s.charAt(left)) == false) {
                ++left;
            }
            while (left < right && Character.isLetterOrDigit(s.charAt(right)) == false) {
                --right;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;
            ++left;
            --right;
        }
        return true;
    }
}