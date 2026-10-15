class Solution {
    public int calPoints(String[] operations) {
       int sum = 0;
       Stack<Integer> stack = new Stack<>();
       for (String item : operations) {
            if (item.equals("D")) {
                sum += stack.peek() * 2;
                stack.push(stack.peek() * 2);
            } else if (item.equals("C")) {
                sum -= stack.pop();
            } else if (item.equals("+")) {
                int last = stack.pop();
                int before_last = stack.peek();
                stack.push(last);
                stack.push(before_last + last);
                sum += before_last + last;
            } else {
                var number = Integer.parseInt(item);
                sum += number;
                stack.push(number);
            }
       }
       return sum;
    }
}