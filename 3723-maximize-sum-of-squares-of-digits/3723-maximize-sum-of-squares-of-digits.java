class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (num * 9 < sum) {
            return "";
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < num; i++) {
            for (int j = 9; j >= 0; j--) {
                if (sum >= j) {
                    sb.append(j);
                    sum -= j;
                    break;
                }
            }
        }

        return sb.toString();
    }
}