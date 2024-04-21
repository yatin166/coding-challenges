package binary_tree.dfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class PathSumIII {

    static int path = 0;

    private static void findPath(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }

        if (root.val == targetSum) {
            path++;
        }

        findPath(root.left, targetSum - root.val);
        findPath(root.right, targetSum - root.val);
    }

    private static int pathSumUsingDFS(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        findPath(root, targetSum);
        findPath(root.left, targetSum);
        findPath(root.right, targetSum);

        return path;
    }

    private static int pathUsingDFSAndMap(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return helper(root, targetSum, 0, map);
    }

    private static int helper(TreeNode root, int targetSum, int currentSum, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }

        currentSum += root.val;
        int ans = map.getOrDefault(currentSum - targetSum, 0);
        map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);

        ans += helper(root.left, targetSum, currentSum, map) + helper(root.right, targetSum, currentSum, map);
        map.put(currentSum, map.get(currentSum) - 1);
        return ans;
    }

    public static void main(String[] args) {
        // TreeNode tree = new TreeNode(10, new TreeNode(5, new TreeNode(3, new TreeNode(3), new TreeNode(-2)), new TreeNode(2, null, new TreeNode(1))), new TreeNode(-3, null, new TreeNode(11)));
        // TreeNode tree = new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null), new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1))));
        TreeNode tree = new TreeNode(1, new TreeNode(-2, new TreeNode(1, new TreeNode(-1), null), new TreeNode(3)), new TreeNode(-3, new TreeNode(-2), null));
        tree.printTree();
        System.out.println();
        System.out.println("ANS: " + pathUsingDFSAndMap(tree, -1));
        System.out.println("PATH: "+ path);
    }
}

















