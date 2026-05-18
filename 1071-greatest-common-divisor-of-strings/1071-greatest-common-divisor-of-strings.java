class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int strLength1 = str1.length();
        int strLength2 = str2.length();
        if (!(str1 + str2).equals(str2 + str1)) return "";
        return str1.substring(0, gcd(strLength1, strLength2));
    }
    public int gcd(int a, int b) {
        while (b != 0) {
            int r = b;
            b = a % b;
            a = r;
        }
        return a;
    }
}