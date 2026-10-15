class Solution {
    public int calPoints(String[] operations) {
       Stack<Integer> stack = new Stack<>();
       for (String item : operations) {
            if (item.equals("D")) {
                stack.push(stack.peek() * 2);
            } else if (item.equals("C")) {
                stack.pop();
            } else if (item.equals("+")) {
                int last = stack.pop();
                int before_last = stack.peek();
                stack.push(last);
                stack.push(before_last + last);
            } else {
                stack.push(Integer.valueOf(item));
            }
       }
       int sum = 0;
       for (Integer n : stack) {
        sum += n;
       }
       return sum;
    }
}