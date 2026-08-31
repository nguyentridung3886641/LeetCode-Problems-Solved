class Solution {
    public int findCenter(int[][] edges) {
        int[] count = new int[edges.length + 2];
        for (int[] i : edges) {
            ++count[i[0]];
            ++count[i[1]];
            if (count[i[0]] == 2) return i[0];
            if (count[i[1]] == 2) return i[1];
        }
        return 0;
    }
}