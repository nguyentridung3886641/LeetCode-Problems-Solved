import java.util.Arrays;

class Solution {
    public int candy(int[] ratings) {
        if (ratings.length == 1) return 1;
        int[] candy = new int[ratings.length];
        int res = 0;
        Arrays.fill(candy, 1);

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) 
                candy[i] = candy[i - 1] + 1;
        }

        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i])
                candy[i - 1] = Math.max(candy[i - 1], candy[i] + 1);
            res += candy[i];
        }
        if (candy[0] > candy[1])
            candy[0] = Math.max(candy[0], candy[1] + 1);
        res += candy[0];
        return res;
    }
}