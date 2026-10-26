class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = 0, n = matrix.length, c = matrix[0].length - 1;
        while (r < n && c >= 0) {
            if (target < matrix[r][c]) {
                --c;
            } else if (matrix[r][c] < target) {
                ++r;
            } else {
                return true;
            }
        }
        return false;
    }
}
