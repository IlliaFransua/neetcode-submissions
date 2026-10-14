class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max_ones_len = 0;
        boolean consecutive = false;
        int current_cons_size = 0;
        for (int i = 0; i < nums.length; ++i) {
            while(i < nums.length && nums[i] == 0)
                ++i;
            if (i == nums.length)
                return max_ones_len;
            current_cons_size = 0;
            while(i < nums.length && nums[i] == 1) {
                ++current_cons_size;
                ++i;
            }
            max_ones_len = Math.max(current_cons_size, max_ones_len);
        }
        return max_ones_len;
    }
}