class MinStack {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> mins = new Stack<>();

    public MinStack() {
    }
    
    public void push(int val) {
        stack.push(val);
        if (mins.isEmpty() || val <= mins.peek()) {
            mins.push(val);
        }
    }
    
    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        int top = stack.pop();
        if (top == mins.peek()) {
            mins.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return mins.peek();
    }
}
