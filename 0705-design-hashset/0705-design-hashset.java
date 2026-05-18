class MyHashSet {
    class Node {
        int key;
        Node next;
        Node(int key) {
            this.key = key;
        }
    }

    private final int SIZE = 10000;
    private Node[] buckets;

    public MyHashSet() {
        buckets = new Node[SIZE];
        for (int i = 0; i < SIZE; i++) {
            buckets[i] = new Node(-1);
        }
    }

    public Node findPrev(int key) {
        int hashCode = key % SIZE;
        Node prev = buckets[hashCode];
        Node cur = buckets[hashCode].next;
        while (cur != null && cur.key != key) {
            prev = cur;
            cur = cur.next;
        }
        return prev;
    }

    public void add(int key) {
        Node prev = findPrev(key);
        if (prev.next != null) return;
        else {
            Node newNode = new Node(key);
            prev.next = newNode;
        }
    }
    
    public void remove(int key) {
        Node prev = findPrev(key);
        if (prev.next == null) return;
        else {
            prev.next = prev.next.next;
        }
    }
    
    public boolean contains(int key) {
        Node prev = findPrev(key);
        if (prev.next != null) return true;
        else return false;    
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */