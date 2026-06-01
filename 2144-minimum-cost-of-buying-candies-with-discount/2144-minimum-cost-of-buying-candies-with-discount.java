import java.util.Arrays;

class Solution {
    public int minimumCost(int[] cost) {
        int costLength = cost.length;
        Arrays.sort(cost);

        for (int i = 0; i < costLength / 2; i++) {
            int temp = cost[i];
            cost[i] = cost[costLength - i - 1];
            cost[costLength - i - 1] = temp;
        }


        int totalCost = 0, freeCandies = 2;
        for (int i = 0; i < costLength; i++) {
            if (i != freeCandies)
                totalCost += cost[i];
            else freeCandies += 3;
        }
        return totalCost;
    }
}