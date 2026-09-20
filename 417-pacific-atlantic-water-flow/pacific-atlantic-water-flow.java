class Solution {
    int m, n;
    int[][] heights;
    boolean[][] pacific;
    boolean[][] atlantic;

    int[][] dirs = {
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        m = heights.length;
        n = heights[0].length;

        pacific = new boolean[m][n];
        atlantic = new boolean[m][n];

        // Pacific: top row + left column
        for (int i = 0; i < m; i++) {
            dfs(i, 0, pacific);
        }

        for (int j = 0; j < n; j++) {
            dfs(0, j, pacific);
        }

        // Atlantic: bottom row + right column
        for (int i = 0; i < m; i++) {
            dfs(i, n - 1, atlantic);
        }

        for (int j = 0; j < n; j++) {
            dfs(m - 1, j, atlantic);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }

    void dfs(int r, int c, boolean[][] visited) {

        if (visited[r][c]) {
            return;
        }

        visited[r][c] = true;

        for (int[] dir : dirs) {

            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                continue;
            }

            // Reverse flow:
            // We can move to a cell that is >= current height
            if (!visited[nr][nc] &&
                heights[nr][nc] >= heights[r][c]) {

                dfs(nr, nc, visited);
            }
        }
    }
}