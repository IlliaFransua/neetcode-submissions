class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0, r = matrix.length - 1, mid = 0;
        while (l <= r) {
            mid = l + (r - l) / 2;

            int min = matrix[mid][0];
            int max = matrix[mid][matrix[mid].length - 1];

            if (target < min) {
                r = mid - 1;
            } else if (max < target) {
                l = mid + 1;
            } else {
                break;
            }
        }
        if (l > r) return false;
        return contains(matrix[mid], target);
    }

    private boolean contains(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) / 2);
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

}
