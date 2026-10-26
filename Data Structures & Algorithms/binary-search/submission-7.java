class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + ((r - l) / 2);

            if (target < nums[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return (l > 0 && nums[l - 1] == target) ? l - 1 : -1;
    }
}