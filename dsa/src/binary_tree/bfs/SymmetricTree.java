package binary_tree.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

    private static boolean isSymmetric(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null || rightNode == null) {
            return leftNode == rightNode;
        }

        if (leftNode.val != rightNode.val) {
            return false;
        }

        return isSymmetric(leftNode.left, rightNode.right) && isSymmetric(leftNode.right, rightNode.left);
    }

    private static boolean isSymmetricUsingBFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode leftNode = queue.poll();
                TreeNode rightNode = queue.poll();
                if (leftNode == null && rightNode == null) {
                    continue;
                }
                if (leftNode == null || rightNode == null) {
                    return false;
                }
                if (leftNode.val != rightNode.val) {
                    return false;
                }
                queue.add(leftNode.left);
                queue.add(rightNode.right);
                queue.add(leftNode.right);
                queue.add(rightNode.left);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        //TreeNode tree = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        TreeNode tree = new TreeNode(1, new TreeNode(2, null, new TreeNode(3)), new TreeNode(2, null, new TreeNode(3)));
        //System.out.println(isSymmetric(tree.left, tree.right));
        System.out.println(isSymmetricUsingBFS(tree));
    }
}
