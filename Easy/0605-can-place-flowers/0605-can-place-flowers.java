class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int l = flowerbed.length;
        for (int i = 0; i < l; i++) {
            boolean prev = false, next = false;
            if (flowerbed[i] == 1) {
                continue;
            }
            if (i - 1 < 0 || flowerbed[i - 1] == 0) {
                prev = true;
            }

            if (i + 1 > l - 1 || flowerbed[i + 1] == 0) {
                next = true;
            }

            if (prev == true && next == true) {
                flowerbed[i] = 1;
                n--;
            }
        }
        return (n > 0) ? false : true;
    }
}