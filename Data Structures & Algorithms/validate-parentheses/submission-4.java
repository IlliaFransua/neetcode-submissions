class Solution {
    public boolean isValid(String s) {
       Stack<Character> stack = new Stack<>();
       Map<Character, Character> closeToOpen = new HashMap<>();
       closeToOpen.put(')', '(');
       closeToOpen.put(']', '[');
       closeToOpen.put('}', '{');

       for (char c : s.toCharArray()) {
        if (closeToOpen.containsKey(c)) {
            if (stack.isEmpty() || stack.peek() != closeToOpen.get(c)) {
                return false;
            } else {
                stack.pop();
            }
        } else {
            stack.push(c);
        }
       } 
       return stack.isEmpty();
    }
}
