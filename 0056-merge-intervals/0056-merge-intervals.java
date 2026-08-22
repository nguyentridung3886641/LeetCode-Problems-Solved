class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int prev[] = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (prev[1] >= intervals[i][0]) {
                prev[1] = Math.max(prev[1], intervals[i][1]);
            }
            else {
                res.add(prev);
                prev = intervals[i];
            }
        }

        res.add(prev);
        return res.toArray(new int[res.size()][]);
    }
}