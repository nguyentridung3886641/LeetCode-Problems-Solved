class MyLinkedList {
    class Node {
        int val;
        Node next;
        Node (int val) {
            this.val = val;
        }
    }
    private Node dummy;
    private Node head;
    private int size;
    public MyLinkedList() {
        head = null;
        size = 0;
        dummy = new Node(0);
        dummy.next = head;
    }
    
    public int get(int index) {
        Node curr = dummy;
        if (index >= size || index < 0) {
            return -1;
        }
        else {
            for (int i = 0; i < index + 1; i++) {
                curr = curr.next;
            }
        }
        return curr.val;
    }
    
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = dummy.next;
        dummy.next = newNode;
        ++size;
    }
    
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        Node curr = dummy;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
        ++size;
    }
    
    public void addAtIndex(int index, int val) {
        Node newNode = new Node(val);
        Node curr = dummy;
        if (index >= 0 && index <= size) {
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
            newNode.next = curr.next;
            curr.next = newNode;
            ++size;
        }
    }
    
    public void deleteAtIndex(int index) {
        Node curr = dummy;
        if (index >= 0 && index < size) {
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
            curr.next = curr.next.next;
            --size;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */