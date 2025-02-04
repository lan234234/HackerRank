package mathworks;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class NoAncestorSubset {
    public int solution(int treeNodes, int[] treeFrom, int[] treeTo, int[] weight) {
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < treeNodes + 1; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 0; i < treeFrom.length; i++) {
            tree.get(treeFrom[i]).add(treeTo[i]);
        }

        return getMaxSubsetSum(tree, 1, weight);
    }

    private int getMaxSubsetSum(List<List<Integer>> tree, int node, int[] weight) {
        int childSum = 0;
        for (int child : tree.get(node)) {
            childSum += getMaxSubsetSum(tree, child, weight);
        }
        return Math.max(childSum, weight[node - 1]);
    }
}
