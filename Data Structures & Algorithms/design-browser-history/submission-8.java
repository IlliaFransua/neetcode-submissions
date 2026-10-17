class BrowserHistory {

    private ArrayList<String> history;
    private int curr;

    public BrowserHistory(String homepage) {
        history = new ArrayList<>();
        history.add(homepage);
        curr = 0;
    }
    
    public void visit(String url) {
        // for (int i = curr + 1; i < history.size(); ++i) {
        //     history.remove(i);
        // }
        // history.add(url);
        ++curr;
        history = new ArrayList<String>(history.subList(0, curr));
        history.add(url);
    }
    
    public String back(int steps) {
        curr = Math.max(0, curr - steps);
        return history.get(curr);
    }
    
    public String forward(int steps) {
        curr = Math.min(curr + steps, history.size() - 1);
        return history.get(curr);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */