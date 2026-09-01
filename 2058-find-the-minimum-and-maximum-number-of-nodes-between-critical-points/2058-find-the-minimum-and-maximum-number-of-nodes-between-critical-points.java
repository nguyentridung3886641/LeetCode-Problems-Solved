class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return new int[]{-1, -1};

        ListNode prev = head, cur = head.next;
        int curIndex = 1, maxDistance = 0, minDistance = Integer.MAX_VALUE;
        int firstCritical = -1, lastCritical = -1;

        while (cur.next != null) {
            if (cur.val > prev.val && cur.val > cur.next.val ||
                cur.val < prev.val && cur.val < cur.next.val) {
                if (firstCritical == -1)
                    firstCritical = curIndex;
                if (lastCritical != -1)
                    minDistance = Math.min(minDistance, curIndex - lastCritical);
                lastCritical = curIndex;
            }
            prev = prev.next;
            cur = cur.next;
            ++curIndex;
        }

        if (firstCritical == -1 || firstCritical == lastCritical)
            return new int[]{-1, -1};

        maxDistance = lastCritical - firstCritical;
        return new int[]{minDistance, maxDistance};
    }
}