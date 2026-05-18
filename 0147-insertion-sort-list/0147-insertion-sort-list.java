class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        ListNode lastSorted = head;
        dummy.next = head;
        while (lastSorted != null && lastSorted.next != null) {
            ListNode curr = lastSorted.next;
            ListNode prev = dummy;
            if (curr.val >= lastSorted.val) {
                lastSorted = lastSorted.next;
            }
            else {
                while (prev.next.val < curr.val) {
                prev = prev.next;
                }
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
        }
        return dummy.next;
    }
}