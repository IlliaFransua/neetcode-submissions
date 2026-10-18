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

class Deque {

    private ListNode left;
    private ListNode right;

    public Deque() {
        left = new ListNode(0);
        right = new ListNode(0);
        left.next = right;
        right.prev = left;
    }

    public boolean isEmpty() {
        return left.next == right;
    }

    private void insertNode(ListNode node, ListNode prev, ListNode next) {
        prev.next = node;
        node.prev = prev;
        node.next = next;
        next.prev = node;
    }

    public void append(int value) {
       insertNode(new ListNode(value), right.prev, right);
    }

    public void appendleft(int value) {
       insertNode(new ListNode(value), left, left.next);
    }

    private void popNode(ListNode node) {
        ListNode prev = node.prev;
        ListNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        int res = right.prev.val;
        popNode(right.prev);
        return res;
    }

    public int popleft() {
        if (isEmpty()) {
            return -1;
        }
        int res = left.next.val;
        popNode(left.next);
        return res;
    }
}
