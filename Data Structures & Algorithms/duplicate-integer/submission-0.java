class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (var n : nums) {
            if (!set.add(n)) {
                return true;
            }
        }
        return false;
    }
}