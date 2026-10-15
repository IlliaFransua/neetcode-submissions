class Solution {
    public int[] getConcatenation(int[] nums) {
       int[] res = new int[nums.length * 2];
        for (int i = 0, k = nums.length; i < nums.length; ++i, ++k) {
            res[i] = nums[i];
            res[k] = nums[i];
        }
        return res;
    }
}