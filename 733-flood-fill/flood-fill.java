class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];

        // If the color is already the same, nothing to do
        if (originalColor == color) {
            return image;
        }

        dfs(image, sr, sc, originalColor, color);

        return image;
    }

    private void dfs(int[][] image, int r, int c, int originalColor, int color) {

        // Out of bounds
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length) {
            return;
        }

        // Not part of the same region
        if (image[r][c] != originalColor) {
            return;
        }

        // Change color
        image[r][c] = color;

        // Visit 4 directions
        dfs(image, r + 1, c, originalColor, color); // down
        dfs(image, r - 1, c, originalColor, color); // up
        dfs(image, r, c + 1, originalColor, color); // right
        dfs(image, r, c - 1, originalColor, color); // left
    }
}