class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max_ones_len = 0;
        int start_cons = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0)
                continue;
            start_cons = i;
            while(i < nums.length && nums[i] == 1)
                ++i;
            max_ones_len = Math.max(i - start_cons, max_ones_len);
        }
        return max_ones_len;
    }
}