class Solution {
    public boolean isValid(String s) {
       Stack<Character> stack = new Stack<>();
       for (char c : s.toCharArray()) {
        if (c == '}' || c == ']' || c == ')') {
            if (stack.size() == 0) {
                return false;
            }
            Character last = switch(stack.pop()) {
                case '{' -> '}';
                case '[' -> ']';
                case '(' -> ')';
                default -> ' ';
            };
            if (!last.equals(c)) {
                return false;
            }
        } else {
            stack.push(c);
        }
       } 
       return stack.size() == 0;
    }
}
