import java.util.Arrays;

class Solution {
    public String largestNumber(int[] nums) {
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = Integer.valueOf(nums[i]).toString();
        }
        Arrays.sort(str, (a, b) -> (b + a).compareTo(a + b));
        int i = 0;
        while (i < nums.length && str[i].equals("0"))
            i++;
        if (i == nums.length) return "0";
        StringBuilder res = new StringBuilder();
        for (; i < nums.length; i++) {
            res.append(str[i]);
        }
        return res.toString();
    }
}