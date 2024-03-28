package binary_tree.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderSuccessorOfNode {

    private static TreeNode levelOrderSuccessorOfNode(TreeNode root, TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode polledNode = queue.poll();
            if (polledNode.left != null) {
                queue.offer(polledNode.left);
            }
            if (polledNode.right != null) {
                queue.offer(polledNode.right);
            }
            if (polledNode == node) {
                break;
            }
        }

        return queue.peek();
    }

    public static void main(String[] args) {
        TreeNode right = new TreeNode(8, new TreeNode(7), new TreeNode(11, new TreeNode(2, null, new TreeNode(44)), null));
        TreeNode left = new TreeNode(4, new TreeNode(12), new TreeNode(14, new TreeNode(36), new TreeNode(9)));
        TreeNode tree = new TreeNode(3, left, right);
        System.out.println(levelOrderSuccessorOfNode(tree, right.right).val);
    }
}
