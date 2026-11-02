class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(nums, new HashSet<>(), res, 0);
        return res;
    }

    private void backtracking(int[] nums, 
                Set<Integer> curr, List<List<Integer>> res, int index) {
        res.add(List.copyOf(curr));

        if (curr.size() == nums.length) return;

        for (int i = index; i < nums.length; ++i) {
            if (curr.add(nums[i])) {
                backtracking(nums, curr, res, i);
                curr.remove(nums[i]);
            }
        }
    }
}
