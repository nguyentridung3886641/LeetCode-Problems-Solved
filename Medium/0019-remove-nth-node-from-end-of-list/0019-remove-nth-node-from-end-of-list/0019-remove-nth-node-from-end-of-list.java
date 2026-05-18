class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;
        else if (head.next == null) return null;
        ListNode dummy = new ListNode(0);
        ListNode fast = dummy, slow = dummy;
        dummy.next = head;
        for (int i = 0; i < n; ++i) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        if (slow.next == head) head = slow.next.next;
        slow.next = slow.next.next;
        return head;
    }
}