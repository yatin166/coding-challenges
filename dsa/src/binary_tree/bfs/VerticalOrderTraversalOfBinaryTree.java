package binary_tree.bfs;

import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class VerticalOrderTraversalOfBinaryTree {

    private static List<List<Integer>> verticalOrderTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        int col = 0;
        Queue<Map.Entry<TreeNode, Integer>> queue = new ArrayDeque<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        queue.offer(new AbstractMap.SimpleEntry<>(root, col));

        int min = 0;
        int max = 0;

        while (!queue.isEmpty()) {
            Map.Entry<TreeNode, Integer> removed = queue.poll();
            TreeNode node = removed.getKey();
            col = removed.getValue();

            if (node != null) {
                if (!map.containsKey(col)) {
                    map.put(col, new ArrayList<>());
                }

                map.get(col).add(node.val);

                min = Math.min(min, col);
                max = Math.max(max, col);

                if (node.left != null) {
                    queue.offer(new AbstractMap.SimpleEntry<>(node.left, col - 1));
                }
                if (node.right != null) {
                    queue.offer(new AbstractMap.SimpleEntry<>(node.right, col + 1));
                }
            }
        }

        for (int i = min; i <= max; i++) {
            ans.add(map.get(i));
        }

        return ans;

    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(6)), new TreeNode(3, new TreeNode(5), new TreeNode(7)));
        System.out.println(verticalOrderTraversal(tree));
    }
}
