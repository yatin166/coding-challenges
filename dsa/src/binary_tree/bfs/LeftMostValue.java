package binary_tree.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class LeftMostValue {

    private static int leftMostValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int leftMostValue = root.val;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                    leftMostValue = currentNode.left.val;
                }

                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }

        return leftMostValue;
    }

    public static void main(String[] args) {
        //TreeNode tree = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, new TreeNode(5, new TreeNode(7), null), new TreeNode(6)));
        TreeNode tree = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println(leftMostValue(tree));
    }
}
