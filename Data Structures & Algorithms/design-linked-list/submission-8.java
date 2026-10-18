class ListNode {
    int val;
    ListNode prev;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
        prev = null;
        next = null;
    }
}

class MyLinkedList {

    private ListNode left;
    private ListNode right;
    private int size;

    public MyLinkedList() {
        left = new ListNode(0);
        right = new ListNode(0);
        left.next = right;
        right.prev = left;
        size = 0;
    }

    private ListNode getPrev(int index) {
        if (index <= size / 2) {
            var curr = left;
            for (int i = 0; i < index; ++i) {
                curr = curr.next;
            }
            return curr;
        } else {
            var curr = right;
            for (int i = 0; i < size + 1 - index; ++i) {
                curr = curr.prev;
            }
            return curr;
        }
    }

    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        return getPrev(index).next.val;
    }

    private void insertNode(ListNode node, ListNode prev, ListNode next) {
        prev.next = node;
        node.prev = prev;
        node.next = next;
        next.prev = node;
        ++size;
    }
    
    public void addAtHead(int val) {
        var prev = left;
        var next = left.next;
        var node = new ListNode(val);
        insertNode(node, prev, next);
    }
    
    public void addAtTail(int val) {
        var prev = right.prev;
        var next = right;
        var node = new ListNode(val);
        insertNode(node, prev, next);
    }
    
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return;
        ListNode prev = getPrev(index);
        insertNode(new ListNode(val), prev, prev.next);
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        var prev = getPrev(index);
        var next = prev.next.next;
        prev.next = next;
        next.prev = prev;
        --size;
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