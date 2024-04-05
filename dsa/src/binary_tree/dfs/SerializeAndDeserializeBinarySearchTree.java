package binary_tree.dfs;

import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SerializeAndDeserializeBinarySearchTree {

    /*static Deque<TreeNode> queue = new LinkedList<>();*/

    private static TreeNode helper(TreeNode root, StringBuilder nodes) {
        if (root == null) {
            /*queue.offer(null);*/
            nodes.append("null").append(",");
            return null;
        }
        /*queue.offer(root);*/
        nodes.append(root.val).append(",");
        helper(root.left, nodes);
        helper(root.right, nodes);
        return root;
    }

    private static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helper(root, sb);
        return sb.toString();
    }

    private static TreeNode deserialize(String data) {
        Deque<TreeNode> queue = new LinkedList<>();
        String[] nodes = data.split(",");
        for (String val : nodes) {
            if (val.equals("null")) {
                queue.offer(null);
            } else {
                queue.offer(new TreeNode(Integer.parseInt(val)));
            }
        }
        return helper2(queue);
    }

    private static TreeNode helper2(Deque<TreeNode> queue) {
        TreeNode node = queue.poll();
        if (node == null) {
            return null;
        }
        node.left = helper2(queue);
        node.right = helper2(queue);
        return node;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(6, new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(5, new TreeNode(4), null)), new TreeNode(9, new TreeNode(8), new TreeNode(18)));
        String serializedString = serialize(tree);
        System.out.println(serializedString);
        System.out.println();
        TreeNode root = deserialize(serializedString);
        root.printTree();
    }
}
