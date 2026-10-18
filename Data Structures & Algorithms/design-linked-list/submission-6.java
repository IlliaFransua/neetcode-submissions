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

    public MyLinkedList() {
        left = new ListNode(0);
        right = new ListNode(0);
        left.next = right;
        right.prev = left;
    }
    
    public int get(int index) {
        var curr = left.next;
        while (curr != null && index > 0) {
            curr = curr.next;
            --index;
        }
        if (curr != null && curr != right && index == 0) {
            return curr.val;
        }
        return -1;
    }

    private void insertNode(ListNode node, ListNode prev, ListNode next) {
        prev.next = node;
        node.prev = prev;
        node.next = next;
        next.prev = node;
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
        var curr = left.next;
        while (curr != null && index > 0) {
            curr = curr.next;
            --index;
        }
        if (curr != null && index == 0) {
            insertNode(new ListNode(val), curr.prev, curr);
        }
    }
    
    public void deleteAtIndex(int index) {
        var curr = left.next;
        while (curr != null && index > 0) {
            curr = curr.next;
            --index;
        }
        if (curr != null && curr != right && index == 0) {
            var prev = curr.prev;
            var next = curr.next;
            prev.next = next;
            next.prev = prev;
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