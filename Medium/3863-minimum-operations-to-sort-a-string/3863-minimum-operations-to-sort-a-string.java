class Solution {
    public int minOperations(String s) {
        int n = s.length();
        boolean isSorted = true;

        if (n == 1) return 0;
        if (n == 2 && s.charAt(0) > s.charAt(1)) return -1;

        int min = 26, max = 0;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, s.charAt(i) - 'a');
            max = Math.max(max, s.charAt(i) - 'a');

            if (isSorted == true && i > 0 && s.charAt(i) < s.charAt(i - 1)) {
                isSorted = false;
            }
        }

        if (isSorted == true) return 0;
        if (s.charAt(0) - 'a' == min || s.charAt(n - 1) - 'a' == max) return 1;
        
        for (int i = 1; i < n - 1; i++) {
            if (s.charAt(i) - 'a' == min || s.charAt(i) - 'a' == max) return 2;
        }

        return 3;
    }
}