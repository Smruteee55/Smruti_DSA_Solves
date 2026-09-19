class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> path = new ArrayList<>();
        path.add(0);

        dfs(0, graph, path, result);

        return result;
    }

    private void dfs(int node, int[][] graph,
                     List<Integer> path,
                     List<List<Integer>> result) {

        // Reached destination
        if (node == graph.length - 1) {
            result.add(new ArrayList<>(path));
            return;
        }

        // Visit all neighbors
        for (int neighbor : graph[node]) {

            path.add(neighbor);

            dfs(neighbor, graph, path, result);

            // Backtrack
            path.remove(path.size() - 1);
        }
    }
}