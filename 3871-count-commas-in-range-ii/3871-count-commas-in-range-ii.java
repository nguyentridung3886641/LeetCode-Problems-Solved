class Solution {
    public long countCommas(long n) {
        long temp = n, res = 0;
        int count = 0;

        while (temp != 0) {
            temp /= 10;
            ++count;
        }

        if (count < 4) {
            return 0;
        }

        for (int i = 4; i < count; i++) {
            res += (long)Math.pow(10, i - 1) * 9 * ((i - 1) / 3);
        }

        return res + (n - (long)Math.pow(10, count - 1) + 1) * ((count - 1) / 3);
    }
}