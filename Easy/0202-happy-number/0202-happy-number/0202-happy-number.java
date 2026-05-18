import java.util.HashSet;

class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (n != 1) {
            int sumSD = 0;
            while (n > 0) {
                int digit = n % 10;
                sumSD += digit * digit;
                n /= 10;
            }
            if (set.add(sumSD) == false) return false;
            n = sumSD;
        }
        return true;
    }
}