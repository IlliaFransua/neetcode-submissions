class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] cnt = new int[2];
        for (var st : students) {
            cnt[st] += 1;
        }
        int res = students.length;

        for (var sandwich : sandwiches) {
            if (cnt[sandwich] == 0) {
                break;
            }
            --cnt[sandwich];
            --res;
        }

        return res;
    }
}