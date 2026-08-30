class Solution {
    public int maxProfit(int[] prices) {
        int maxProfitInTerm = 0, lastStock = prices[0], maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - lastStock < maxProfitInTerm) {
                lastStock = prices[i];
                maxProfit += maxProfitInTerm;
                maxProfitInTerm = 0;
            }
            maxProfitInTerm = Math.max(maxProfitInTerm, prices[i] - lastStock);
        }
        maxProfit += maxProfitInTerm;
        return maxProfit;
    }
}