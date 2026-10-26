class Solution {
    public int search(int[] nums, int target) {
        return recursive(nums, target, 0, nums.length - 1);
    }

    private int recursive(int[] nums, int target, int l, int r) {
        if (l > r) return -1;

        int mid = l + ((r - l) / 2);
        if (target == nums[mid]) return mid;

        return target < nums[mid] ?
            recursive(nums, target, l, mid - 1) :
            recursive(nums, target, mid + 1, r);
    }
}
