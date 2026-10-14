class Solution {
    public int removeElement(int[] nums, int val) {
        int res_size = 0;
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast];
                ++res_size;
            }
            ++fast;
        }
        return res_size;
    }
}