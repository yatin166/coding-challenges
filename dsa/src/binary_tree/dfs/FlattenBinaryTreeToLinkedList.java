package binary_tree.dfs;

import java.util.LinkedList;
import java.util.Queue;

public class FlattenBinaryTreeToLinkedList {

    private static void preOrder(TreeNode node, Queue<TreeNode> queue) {
        if (node == null) {
            return;
        }

        queue.offer(node);
        preOrder(node.left, queue);
        preOrder(node.right, queue);
    }

    private static TreeNode flattenUsingNormalPreorder(TreeNode root) {
        if (root == null) {
            return root;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        preOrder(root, queue);

        while (!queue.isEmpty()) {
            queue.peek().left = null;
            queue.poll().right = queue.peek();
        }
        return root;
    }

    private static TreeNode flatten(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode currentNode = root;
        while (currentNode != null) {
            if (currentNode.left != null) {
                TreeNode tempNode = currentNode.left;
                while (tempNode.right != null) {
                    tempNode = tempNode.right;
                }
                tempNode.right = currentNode.right;
                currentNode.right = currentNode.left;
                currentNode.left = null;
            }
            currentNode = currentNode.right;
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, null, new TreeNode(6)));
        TreeNode node = flatten(tree);
        node.prettyDisplay(node);
    }
}
