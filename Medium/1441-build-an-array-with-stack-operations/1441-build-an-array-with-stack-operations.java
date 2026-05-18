import java.util.*;

class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int targetLength = target.length;
        int j = 0;
        for (int i = 1; i <= n && j < targetLength; i++) {
            res.add("Push");
            if (i == target[j])
                j++;
            else {
                res.add("Pop");
            }
        }
        return res;
    }
}