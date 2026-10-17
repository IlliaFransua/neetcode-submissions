class ListNode {
    int val;
    ListNode next;

    public ListNode() { }
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class LinkedList {

    private ListNode head = null;
    private ListNode tail = null;
    private int size = 0;

    public LinkedList() {

    }

    private ListNode getNode(int index) {
       if (index < 0 || index >= size) return null;
       ListNode curr = head;
       for (int i = 0; i < index; ++i) {
        curr = curr.next;
       }
       return curr;
    }

    public int get(int index) {
       if (index < 0 || index >= size) return -1;
       ListNode curr = head;
       for (int i = 0; i < index; ++i) {
        curr = curr.next;
       }
       return curr.val;
    }

    public void insertHead(int val) {
        head = new ListNode(val, head);
        if (head.next == null) {
            tail = head;
        }
        ++size;
    }

    public void insertTail(int val) {
        ListNode newTail = new ListNode(val, null);
        if (tail == null) {
            head = newTail;
        } else {
            tail.next = newTail;
        }
        tail = newTail;
        ++size;
    }

    public boolean remove(int index) {
        if (index < 0 || index >= size) return false;
        if (index == 0) {
            head = head.next;
            --size;
            return true;
        }
        if (index == size - 1) {
            tail = getNode(size - 2);
            tail.next = tail.next.next;
            --size;
            return true;
        }
        ListNode curr = head;
        for (int i = 0; i + 1 < index; ++i) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        --size;
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> res = new ArrayList<>();
        ListNode curr = head;
        for (int i = 0; i < size; ++i) {
            res.add(curr.val);
            curr = curr.next;
        }
        return res;
    }
}
