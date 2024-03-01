package recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {

    private static void sourceToDestination(int[][] graph, int nextNode, List<Integer> tempList, int target, List<List<Integer>> result) {
        if (nextNode == target) {
            result.add(new ArrayList<>(tempList));
            result.get(result.size() - 1).add(nextNode);
            return;
        }

        for (int index = 0; index < graph[nextNode].length; index++) {
            tempList.add(nextNode);
            sourceToDestination(graph, graph[nextNode][index], tempList, target, result);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[][] graph = { {1,2},{3},{3},{} };
        List<List<Integer>> result = new ArrayList<>();
        sourceToDestination(graph, 0, new ArrayList<>(), graph.length - 1, result);
        System.out.println(result);
    }
}
