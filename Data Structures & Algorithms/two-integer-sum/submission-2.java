class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[][] numbers = new int[nums.length][2];
        for (int i = 0; i < nums.length; ++i) {
            numbers[i][0] = nums[i];
            numbers[i][1] = i;
        }

        Arrays.sort(numbers, Comparator.comparingInt(a -> a[0]));

        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (numbers[left][0] + numbers[right][0] > target) {
                --right;
            } else if (numbers[left][0] + numbers[right][0] < target) {
                ++left;
            } else {
                return new int[] {Math.min(numbers[left][1], numbers[right][1]), Math.max(numbers[left][1], numbers[right][1])};
            }
        }
        return new int[0];
    }
}
