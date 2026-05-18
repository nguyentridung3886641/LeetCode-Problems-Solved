class Solution {
    public boolean rotateString(String s, String goal) {
        String combined = s + s;
        if (s.length() != goal.length()) return false;
        if (combined.contains(goal)) return true;
        else return false;
    }
}