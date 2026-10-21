class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int st_length = students.length;
        int hungry_st = st_length;
        int index = 0;

        for (var sandwich : sandwiches) {
            int cnt = 0;
            while (cnt < st_length && students[index] != sandwich) {
                ++index;
                index %= st_length;
                ++cnt;
            }
            if (students[index] == sandwich) {
                students[index] = -1;
                --hungry_st;
            } else {
                break;
            }
        }

        return hungry_st;
    }
}