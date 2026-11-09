class Solution {
    public int countPaths(int[][] grid) {
        if (grid.length == 0) return 0; 
        return dfs(grid, 0, 0);
    }

    private int dfs(int[][] grid, int r, int c) {
        int rows = grid.length;
        int columns = grid[0].length;
        if (r < 0 || c < 0 || 
            r >= rows || c >= columns || grid[r][c] != 0) {
            return 0;
        }
        if (r == rows - 1 && c == columns - 1) {
            return 1;
        }

        int currNumber = grid[r][c];
        grid[r][c] = -1;

        int count = 0;
        count += dfs(grid, r - 1, c);
        count += dfs(grid, r + 1, c);
        count += dfs(grid, r, c - 1);
        count += dfs(grid, r, c + 1);

        grid[r][c] = currNumber;

        return count;
    }
}
