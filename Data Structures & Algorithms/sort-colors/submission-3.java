class Solution {
    public void sortColors(int[] nums) {
        int i = 0;
        int left = 0;
        int right = nums.length - 1;
        while (i <= right) {
            if (nums[i] == 0) {
                swap(nums, left, i);
                ++left;
            } else if (nums[i] == 2) {
                swap(nums, i, right);
                --right;
                --i;
            }
            ++i;
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}