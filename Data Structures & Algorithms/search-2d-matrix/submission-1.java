class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0, r = matrix.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            int min = matrix[mid][0];
            int max = matrix[mid][matrix[mid].length - 1];
            if (min <= target && target <= max) {
                for (int i = 0; i < matrix[mid].length; ++i) {
                    if (matrix[mid][i] == target) return true;
                }
                return false;
            } else if (min <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }

}
