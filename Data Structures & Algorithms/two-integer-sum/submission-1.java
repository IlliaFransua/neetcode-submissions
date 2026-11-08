class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            var index = map.get(nums[i]);
            if (index != null && index != i) {
                return new int[] {index, i}; 
            }
            map.put(target - nums[i], i);
        }
        return new int[0];
    }
}
