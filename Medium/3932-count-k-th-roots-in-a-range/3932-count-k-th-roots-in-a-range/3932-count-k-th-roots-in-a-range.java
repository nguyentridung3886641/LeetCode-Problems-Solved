class Solution {
    public int countKthRoots(int l, int r, int k) {
        int underLimit = (int)Math.ceil(Math.pow(l, 1.0 / k));
        if ((long)Math.pow(underLimit, k) < l) ++ underLimit;
        int upperLimit = (int)Math.floor(Math.pow(r, 1.0 / k));
        if ((long)Math.pow(upperLimit + 1, k) <= r) ++upperLimit;
        if (underLimit > upperLimit) return 0;
        return upperLimit - underLimit + 1;
    }
}