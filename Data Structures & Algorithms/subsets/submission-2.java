class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) return null;
        List<List<Integer>> res = new ArrayList<>();
        res.add(List.of());

        for (var n : nums) {
            int size = res.size();
            for (int i = 0; i < size; ++i) {
                List<Integer> subset = new ArrayList<>(res.get(i));
                subset.add(n);
                res.add(subset);
            }
        }

        return res;
    }
}
