class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;
        dfs(image, image[sr][sc], color, sr, sc); 
        return image;
    }

    private void dfs(int[][] image, int sourceColor, int targetColor, int r, int c) {
        if (r < 0 || c < 0 || r >= image.length || c >= image[0].length || image[r][c] != sourceColor) {
            return;
        }
        image[r][c] = targetColor;

        dfs(image, sourceColor, targetColor, r - 1, c);
        dfs(image, sourceColor, targetColor, r + 1, c);
        dfs(image, sourceColor, targetColor, r, c - 1);
        dfs(image, sourceColor, targetColor, r, c + 1);
    }
}