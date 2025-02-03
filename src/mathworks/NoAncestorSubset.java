package mathworks;

import java.util.ArrayList;
import java.util.List;

public class NoAncestorSubset {
    List<List<Integer>> tree;
    int[] weights;
    int[][] dp;
    public int solution(int treeNodes, int[] treeFrom, int[] treeTo, int[] weight) {
        // Convert to 1-based index
        weights = new int[treeNodes + 1];
        for (int i = 0; i < treeNodes; i++) {
            weights[i + 1] = weight[i];
        }

        // Build tree
        tree = new ArrayList<>();
        for (int i = 0; i <= treeNodes; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 0; i < treeFrom.length; i++) {
            tree.get(treeFrom[i]).add(treeTo[i]);
            tree.get(treeTo[i]).add(treeFrom[i]); // Bidirectional for undirected tree
        }

        // DP array, where dp[node][0] = max sum excluding node, dp[node][1] = max sum including node
        dp = new int[treeNodes + 1][2];

        // Run DFS from root (node 1) with no parent (-1)
        dfs(1, -1);

        // Maximum sum of a valid subset
        return Math.max(dp[1][0], dp[1][1]);
    }

    private void dfs(int node, int parent) {
        dp[node][1] = weights[node]; // If we include this node

        for (int child : tree.get(node)) {
            if (child == parent) continue; // Avoid going back to parent

            dfs(child, node);

            // If we don't include 'node', we can take max of both states of child
            dp[node][0] += Math.max(dp[child][0], dp[child][1]);

            // If we include 'node', we must exclude child
            dp[node][1] += dp[child][0];
        }
    }
}
