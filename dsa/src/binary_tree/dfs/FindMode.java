package binary_tree.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// UNSOLVED

public class FindMode {

    int[] answer;

    private static TreeNode dfs(TreeNode node, Map<Integer, Integer> map) {
        if (node == null) {
            return null;
        }

        map.put(node.val, map.getOrDefault(node.val, 0) + 1);
        dfs(node.left, map);
        dfs(node.right, map);
        return node;
    }

    public static int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, map);
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() >= 2) {
                list.add(entry.getValue());
            }
        }
        return list.stream().mapToInt(i -> i.intValue()).toArray();
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1, null, new TreeNode(2, new TreeNode(2), null));
        System.out.println(Arrays.toString(findMode(tree)));
    }
}
