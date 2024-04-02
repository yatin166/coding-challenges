package binary_tree.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class LeftMostValue {

    private static int leftMostValueUsingBFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.right != null)
                queue.add(root.right);
            if (root.left != null)
                queue.add(root.left);
        }
        return root.val;
    }

    private static int level(TreeNode node, int level) {
        if (node == null) {
            return level;
        }

        int leftLevel = level(node.left, level + 1);
        int rightLevel = level(node.right, level + 1);

        return Math.max(leftLevel, rightLevel);
    }

    private static Integer helper(TreeNode node, int rootLevel, int level) {
        if (node == null) {
            return null;
        }
        if (level == rootLevel) {
            return node.val;
        }

        Integer foundInLeft = helper(node.left, rootLevel, level + 1);
        if (foundInLeft != null) {
            return foundInLeft;
        }
        return helper(node.right, rootLevel, level + 1);
    }

    private static int leftMostInLastRow(TreeNode root) {
        int level = level(root, 0);
        System.out.println(level-1);
        return helper(root, level-1, 0);
    }

    public static void main(String[] args) {
        //TreeNode tree = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, new TreeNode(5, new TreeNode(7, null, new TreeNode(8)), null), new TreeNode(6)));
        //TreeNode tree = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        // TreeNode tree = new TreeNode(3, new TreeNode(1, new TreeNode(0), new TreeNode(2)), new TreeNode(5, new TreeNode(4), new TreeNode(6)));
        TreeNode tree = new TreeNode(15, new TreeNode(-1), new TreeNode(20));
        System.out.println(leftMostInLastRow(tree));
    }
}
