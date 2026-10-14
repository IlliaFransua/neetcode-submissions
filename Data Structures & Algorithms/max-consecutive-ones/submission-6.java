class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ones_cons = 0;
        int current_count = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                ones_cons = Math.max(current_count, ones_cons);
                current_count = 0;
            } else {
                ++current_count;
            }
        }
        return Math.max(current_count, ones_cons);
    }
}