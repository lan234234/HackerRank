package mathworks;

import java.util.*;

public class MinimumReversal {
    public int minimumReversal(int gNodes, int[] gFrom, int[] gTo) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < gNodes + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < gFrom.length; i++) {
            graph.get(gFrom[i]).add(new int[]{gTo[i], 1});  // 1 represents out
            graph.get(gTo[i]).add(new int[]{gFrom[i], -1}); // -1 represents in
        }

        int min = Integer.MAX_VALUE;
        Map<List<Integer>, Integer> map = new HashMap<>();
        for (int i = 1; i <= gNodes; i++) {
            min = Math.min(min, dfs(graph, i, -1, map));
        }
        return min;
    }

    private int dfs(List<List<int[]>> graph, int node, int parent, Map<List<Integer>, Integer> map) {
        Integer reversal = map.get(Arrays.asList(node, parent));
        if (reversal != null)    return reversal;

        reversal = 0;
        for (int[] nei : graph.get(node)) {
            if (nei[0] == parent)   continue;
            if (nei[1] == -1) {
                reversal ++;
            }
            reversal += dfs(graph, nei[0], node, map);
        }
        map.put(Arrays.asList(node, parent), reversal);
        return reversal;
    }
}
