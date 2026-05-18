class MyHashMap {
    class Node {
        int key, val;
        Node next;
        Node (int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private Node[] buckets;
    private final int SIZE = 10000;
    public MyHashMap() {
        buckets = new Node[SIZE];
        for (int i = 0; i < SIZE; i++) {
            buckets[i] = new Node(-1, - 1);
        }
    }

    private Node findPrev (int key) {
        int hashCode = key % SIZE;
        Node prev = buckets[hashCode];
        Node cur = buckets[hashCode].next;
        while (cur != null && cur.key != key) {
            prev = cur;
            cur = cur.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        Node newNode = new Node(key, value);
        Node prev = findPrev(key);
        if (prev.next == null) {
            prev.next = newNode;
        }
        else {
            prev.next.val = newNode.val;
        }
    }
    
    public int get(int key) {
        Node prev = findPrev(key);
        if (prev.next == null) return -1;
        else return prev.next.val;
    }
    
    public void remove(int key) {
        Node prev = findPrev(key);
        if (prev.next == null) return;
        else {
            prev.next = prev.next.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */