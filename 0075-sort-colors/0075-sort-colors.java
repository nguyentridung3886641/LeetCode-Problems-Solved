class Solution {
    public void sortColors(int[] a) {
        int n = a.length;
        int L = 0, M = 0, R = n - 1;
        if (n == 1) {
            return;
        }
        while (M <= R) {
            if (a[M] == 0 && M > L) {
                int temp = a[M];
                a[M] = a[L];
                a[L] = temp;
                while (L < n && a[L] == 0) L++;
            } else if (a[M] == 2 && M < R) {
                int temp = a[M];
                a[M] = a[R];
                a[R] = temp;
                while (R >= 0 && a[R] == 2) R--;
            } else {
                M++;
            }
        }
    }
}