class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int area = -1;
        for (int r = 0; r < grid.length; ++r) {
            for (int c = 0; c < grid[0].length; ++c) {
                area = Math.max(area, dfs(grid, r, c));
            }
        }
        return area;
    }

    private int dfs(int[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length ||
            c < 0 || c >= grid[0].length ||
            grid[r][c] != 1) {
            return 0;
        }

        grid[r][c] = 0;
        int count = 1;
        count += dfs(grid, r + 1, c);
        count += dfs(grid, r - 1, c);
        count += dfs(grid, r, c + 1);
        count += dfs(grid, r, c - 1);
        return count;
    }
}
