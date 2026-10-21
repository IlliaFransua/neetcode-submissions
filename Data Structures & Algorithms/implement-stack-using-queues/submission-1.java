class MyStack {

    private Queue<Integer> q1;

    public MyStack() {
        q1 = new LinkedList<Integer>();
    }
    
    public void push(int x) {
        q1.offer(x);
        for (int i = q1.size() - 1; i > 0; --i) {
        q1.offer(q1.remove());
        }
    }
    
    public int pop() {
        return q1.remove();
    }
    
    public int top() {
        return q1.peek();
    }
    
    public boolean empty() {
        return q1.isEmpty();
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