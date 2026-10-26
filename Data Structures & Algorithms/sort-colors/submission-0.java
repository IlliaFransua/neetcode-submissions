class Solution {
    public void sortColors(int[] nums) {
        int[] frequencies = new int[3];
        for (var n : nums) {
            frequencies[n] += 1;
        }
        int index = 0;
        for (int i = 0; i < frequencies.length; ++i) {
            for (int j = 0; j < frequencies[i]; ++j) {
                nums[index++] = i;
            }
        }
    }
}