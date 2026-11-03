class Solution {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(nums, target, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(int[] nums, int target, 
                        List<Integer> curr, int index) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(List.copyOf(curr));
            return;
        }

        for (int i = index; i < nums.length; ++i) {
            curr.add(nums[i]);
            dfs(nums, target - nums[i], curr, i);
            curr.remove(curr.size() - 1);
        }
    }
}
