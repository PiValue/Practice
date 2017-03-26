public class LRUCache {
    private final Map<Integer, DNode> mapping = new HashMap<>();
    private DNode head, tail;
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!mapping.containsKey(key)) return -1;
        moveToFront(key);
        return head.data;
    }

    public void put(int key, int value) {
        if (mapping.containsKey(key)) {
            moveToFront(key);
            head.data = value;
        } else {
            if (mapping.size() >= capacity) {
                mapping.remove(tail.key);
                tail = tail.prev;
                if (tail != null) {
                    tail.next = null;
                }
            }
            DNode node = new DNode(key, value);
            if (head == null) {
                head = node;
                tail = node;
                mapping.put(key, node);
                return;
            }
            node.next = head;
            head.prev = node;
            head = node;
            mapping.put(key, node);
        }
    }
    
    private void moveToFront(int key) {
        DNode node = mapping.get(key);
        if (node == head) return;	// Nothing to move anything.

        DNode prev = node.prev;
        DNode next = node.next;
        prev.next = next;
        if (next == null) {
        	// Tail
        	DNode temp = tail.prev;
        	temp.next = null;
        	tail = temp;
        } else {
        	next.prev = prev;
        }
        node.prev = null;
        node.next = head;
        head.prev = node;
        head = node;
    }

    @Data
    private static class DNode {
        private int key;
        private int data;
        private DNode next, prev;

        
        public DNode(int key, int data) {
            this.key = key;
            this.data = data;
        }
    }
}
