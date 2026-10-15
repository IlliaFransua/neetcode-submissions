class MinStack {

    private List<Integer> array = new ArrayList<>();
    private Stack<Integer> mins = new Stack<>();

    public MinStack() {
    }
    
    public void push(int val) {
        array.add(val);
        if (mins.isEmpty() || val < mins.peek()) {
            mins.push(val);
        } else {
            mins.push(mins.peek());
        }
    }
    
    public void pop() {
        array.remove(array.size() - 1);
        mins.pop();
    }
    
    public int top() {
        return array.get(array.size() - 1);
    }
    
    public int getMin() {
        return mins.peek();
    }
}
