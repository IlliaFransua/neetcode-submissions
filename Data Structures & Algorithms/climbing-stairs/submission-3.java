class Solution {

    private int recursive(int n, int[] memo, int curr, int step) {
        if (curr + step > n) return 0;
        if (curr + step == n) return 1;
        curr += step;
        if (memo[curr] != -1) {
           return memo[curr]; 
        }
        int res = 0;
        res += recursive(n, memo, curr, 1);
        res += recursive(n, memo, curr, 2);
        return memo[curr] = res;
    }

    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        java.util.Arrays.fill(memo, -1);
        return recursive(n, memo, 0, 0);
    }
}
