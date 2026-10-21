class MyStack {

    private Queue<Object> q;

    public MyStack() {
        q = null;
    }
    
    public void push(int x) {
        Queue<Object> item = new LinkedList<Object>();
        item.offer(x);
        item.offer(q);
        q = item;
    }
    
    public int pop() {
        Integer res = (Integer) q.remove();
        q = (Queue<Object>) q.remove();
        return res;
    }
    
    public int top() {
        return (Integer) q.peek();
    }
    
    public boolean empty() {
        return q == null || q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */