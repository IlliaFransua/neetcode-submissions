class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ones_cons = 0;
        int current_count = 0;
        for (int i = 0; i < nums.length; ++i) {
            current_count = (nums[i] == 1) ? current_count + 1 : 0;
            ones_cons = Math.max(current_count, ones_cons);
        }
        return ones_cons;
    }
}