import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        int intervalsLength = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new LinkedList<>();
        res.add(intervals[0]);
        int[] last = intervals[0];
        for (int i = 1; i < intervalsLength; i++) {
            int[] cur = intervals[i];
            if (last[1] < cur[0]) {
                res.add(intervals[i]);
                last = cur;
            }
            else {
                last[1] = Math.max(last[1], cur[1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}