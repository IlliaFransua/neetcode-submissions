class Solution {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(nums, target, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(int[] nums, int target, 
                        List<Integer> curr, int index) {
        if (target == 0) {
            res.add(List.copyOf(curr));
            return;
        }
        if (index >= nums.length || target < 0) {
            return;
        }
        
        curr.add(nums[index]);
        dfs(nums, target - nums[index], curr, index);
        curr.remove(curr.size() - 1);
        dfs(nums, target, curr, index + 1);
    }
}
