class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxStreak = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int curNum = num;
                int curStreak = 1;
                while (set.contains(curNum + 1)) {
                    ++curNum;
                    ++curStreak;
                }
                maxStreak = Math.max(maxStreak, curStreak);
            }
        }
        return maxStreak;
    }
}