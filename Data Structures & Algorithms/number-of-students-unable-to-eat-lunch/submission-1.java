class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q = new LinkedList<>();
        int st_length = students.length;
        for (var st : students) {
            q.offer(st);
        }
        int hungry_st = st_length;

        for (var sandwich : sandwiches) {
            int cnt = 0;
            while (cnt < st_length && q.peek() != sandwich) {
                q.offer(q.remove());
                ++cnt;
            }
            if (q.peek() == sandwich) {
                q.remove();
                --hungry_st;
            } else {
                break;
            }
        }

        return hungry_st;
    }
}