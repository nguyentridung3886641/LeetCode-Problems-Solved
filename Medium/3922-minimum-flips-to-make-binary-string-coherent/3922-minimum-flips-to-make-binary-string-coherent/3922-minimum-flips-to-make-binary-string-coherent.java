class Solution {
    public int minFlips(String s) {
        int n = s.length();

        int ones = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') ones++;
        }

        // Case 1: Make all 0s
        int ans = ones;

        // Case 2: Make all 1s
        ans = Math.min(ans, n - ones);

        // Case 3: Keep exactly one '1'
        // Minimum flips = convert all others to 0
        if (ones > 0) {
            ans = Math.min(ans, ones - 1);
        } else {
            ans = Math.min(ans, 1);
        }

        // Case 4: Form = 1 0...0 1
        if (n >= 2) {
            int middleOnes = 0;

            for (int i = 1; i < n - 1; i++) {
                if (s.charAt(i) == '1') {
                    middleOnes++;
                }
            }

            int flips = middleOnes;

            if (s.charAt(0) == '0') flips++;
            if (s.charAt(n - 1) == '0') flips++;

            ans = Math.min(ans, flips);
        }

        return ans;
    }
}