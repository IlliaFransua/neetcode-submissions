class Solution {

    private int recursive(int n, int[] memo, int curr) {
        if (curr > n) return 0;
        if (curr == n) return 1;
        if (memo[curr] != -1) return memo[curr]; 
        return memo[curr] = recursive(n, memo, curr + 1) 
                            + recursive(n, memo, curr + 2);
    }

    public int climbStairs(int n) {
        int[] memo = new int[n];
        java.util.Arrays.fill(memo, -1);
        return recursive(n, memo, 0);
    }
}