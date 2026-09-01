class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev = head, cur = head.next;
        int curIndex = 1, maxDistance = 0, minDistance = 1000000;
        int firstCritical = 0, lastCritical = -1000000, count = 0;

        if (cur.next == null)
            return new int[]{-1, -1};

        while (cur.next != null) {
            if (cur.val > prev.val && cur.val > cur.next.val) {
                if (firstCritical == 0)
                    firstCritical = curIndex;
                minDistance = Math.min(minDistance, curIndex - lastCritical);
                lastCritical = curIndex;
                ++count;
            } else if (cur.val < prev.val && cur.val < cur.next.val) {
                if (firstCritical == 0)
                    firstCritical = curIndex;
                minDistance = Math.min(minDistance, curIndex - lastCritical);
                lastCritical = curIndex;
                ++count;
            }
            prev = prev.next;
            cur = cur.next;
            ++curIndex;
        }

        if (count < 2)
            return new int[]{-1, -1};

        maxDistance = lastCritical - firstCritical;
        return new int[]{minDistance, maxDistance};
    }
}