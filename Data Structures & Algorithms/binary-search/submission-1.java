class Solution {
    public int search(int[] nums, int target) {
        return recursive(nums, target, 0, nums.length - 1);
    }

    private int recursive(int[] nums, int target, int l, int r) {
        if (l > r) {
            return -1;
        }
        int mid = (l + r) / 2;
        if (target < nums[mid]) {
            return recursive(nums, target, l, mid - 1);
        } else if (target > nums[mid]) {
            return recursive(nums, target, mid + 1, r);
        } else {
            return mid;
        }
    }
}
