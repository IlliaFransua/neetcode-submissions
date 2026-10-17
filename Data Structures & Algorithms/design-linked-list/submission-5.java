class ListNode {
    int val;
    ListNode prev;
    ListNode next;

    public ListNode(int val, ListNode prev, ListNode next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}

class MyLinkedList {

    private ListNode head;
    private ListNode tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
 
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode curr = head;
        while (curr.next != null && index > 0) {
            curr = curr.next;
            --index;
        }
        return curr.val;
    }
    
    public void addAtHead(int val) {
        ListNode newHead = new ListNode(val, null, head);
        if (head != null) {
            head.prev = newHead;
        } else {
            tail = newHead;
        }
        head = newHead;
        ++size;
    }
    
    public void addAtTail(int val) {
        ListNode newTail = new ListNode(val, tail, null);
        if (tail != null) {
            tail.next = newTail;
        } else {
            head = newTail;
        }
        tail = newTail;
        ++size;
    }
    
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }
        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }
        ListNode curr = head;
        while (index - 1 > 0) {
            curr = curr.next;
            --index;
        }
        ListNode newNode = new ListNode(val, curr, curr.next);
        curr.next.prev = newNode;
        curr.next = newNode;
        ++size;
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        if (index == 0) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
            --size;
            return;
        }
        if (index == size - 1) {
            tail = tail.prev;
            tail.next = null;
            --size;
            if (size == 0) {
                head = null;
            }
            return;
        }
        ListNode curr = head;
        while (index - 1 > 0) {
            curr = curr.next;
            --index;
        }
        ListNode toDelete = curr.next;
        curr.next = toDelete.next;
        if (toDelete.next != null) {
            toDelete.next.prev = curr;
        }
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