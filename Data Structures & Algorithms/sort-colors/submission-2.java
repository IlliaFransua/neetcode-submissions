class Solution {
    public void sortColors(int[] nums) {
        int[] frequencies = new int[3];
        for (var n : nums) {
            ++frequencies[n];
        }
        int index = 0;
        for (int i = 0; i < 3; ++i) {
            while (frequencies[i] > 0) {
                nums[index++] = i;
                --frequencies[i];
            }
        }
    }
}