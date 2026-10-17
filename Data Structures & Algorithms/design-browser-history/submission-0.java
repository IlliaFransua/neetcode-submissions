class ListNode {
    String url;
    ListNode prev;
    ListNode next;

    public ListNode(String url, ListNode prev, ListNode next) {
        this.url = url;
        this.prev = prev;
        this.next = next;
    }
}

class BrowserHistory {

    private ListNode current;

    public BrowserHistory(String homepage) {
        current = new ListNode(homepage, null, null);
    }
    
    public void visit(String url) {
        ListNode next = new ListNode(url, current, null);
        current.next = next;
        current = current.next;
    }
    
    public String back(int steps) {
        while (current.prev != null && steps > 0) {
            current = current.prev;
            --steps;
        }
        return current.url;
    }
    
    public String forward(int steps) {
        while (current.next != null && steps > 0) {
            current = current.next;
            --steps;
        }
        return current.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */