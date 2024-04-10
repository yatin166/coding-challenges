package binary_tree.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllNodesDistanceKinBinaryTree {

    static Map<TreeNode, Integer> map = new HashMap<>();

    private static int findNode(TreeNode root, TreeNode target) {
        if (root == null) {
            return -1;
        }

        if (root == target) {
            map.put(root, 0);
            return 0;
        }

        int left = findNode(root.left, target);
        if (left >= 0) {
            map.put(root, left + 1);
            return left + 1;
        }

        int right = findNode(root.right, target);
        if (right >= 0) {
            map.put(root, right + 1);
            return right + 1;
        }
        return -1;
    }

    private static void distanceKUsingDFS(TreeNode root, TreeNode target, int k, int length, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (map.containsKey(root)) {
            length = map.get(root);
        }
        if (length == k) {
            list.add(root.val);
        }
        distanceKUsingDFS(root.left, target, k, length + 1, list);
        distanceKUsingDFS(root.right, target, k, length + 1, list);
    }

    private static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        findNode(root, target);
        distanceKUsingDFS(root, target, k, map.get(root), list);
        return list;
    }

    public static void main(String[] args) {
        TreeNode target = new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4)));
        TreeNode tree = new TreeNode(3, target, new TreeNode(1, new TreeNode(0), new TreeNode(8)));
        System.out.println(distanceK(tree, target, 2));
    }
}
