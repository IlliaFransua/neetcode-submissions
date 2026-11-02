class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(nums.length), res);
        return res; 
    }

    private void dfs(int[] nums, int i, List<Integer> subset, 
                                        List<List<Integer>> res) {
        if (i == nums.length) {
            res.add(List.copyOf(subset));
            return;
        }
        
        Integer curr = Integer.valueOf(nums[i]);
        subset.add(curr);
        dfs(nums, i + 1, subset, res);

        subset.remove(curr);
        dfs(nums, i + 1, subset, res);
    }
}
