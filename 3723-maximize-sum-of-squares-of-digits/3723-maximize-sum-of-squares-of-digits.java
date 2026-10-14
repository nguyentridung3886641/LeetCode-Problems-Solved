class Solution {
    public String maxSumOfSquares(int num, int sum) {
    if (num * 9 < sum) {
        return "";
    }
    
    int nines = sum / 9;
    int rem = sum % 9;
    int zeros = num - nines - (rem > 0 ? 1 : 0);
    StringBuilder sb = new StringBuilder(num);
    sb.append("9".repeat(nines));
    if (rem > 0) {
        sb.append(rem);
    }
    sb.append("0".repeat(zeros));
    return sb.toString();
    }
}