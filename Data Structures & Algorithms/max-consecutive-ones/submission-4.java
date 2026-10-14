class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ones_cons = 0;
        for (int i = 0; i < nums.length; ++i) {
            int current_count = 0;
            for (int j = i; j < nums.length; ++j) {
                if (nums[j] != 1)
                    break;
                ++current_count;
            }
            ones_cons = Math.max(current_count, ones_cons);
        }
        return ones_cons;
    }
}