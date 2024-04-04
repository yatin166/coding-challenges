package binary_tree.dfs;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInBinarySearchTree {

    static int counter = 0;

    private static TreeNode kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return null;
        }

        TreeNode left = kthSmallest(root.left, k);
        if (left != null) {
            return left;
        }
        counter++;
        if (counter == k) {
            return root;
        }
        return kthSmallest(root.right, k);
    }

    private static TreeNode kthSmallestElement(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return null;
        }

        kthSmallestElement(node.left, list);
        list.add(node);
        kthSmallestElement(node.right, list);
        return node;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(5, new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4)), new TreeNode(6));
        List<TreeNode> list = new ArrayList<>();
        kthSmallestElement(tree, list);
        list.stream().forEach(node -> System.out.print(node.val + ""));
        System.out.println();
        System.out.println(kthSmallest(tree, 3).val);
    }
}
