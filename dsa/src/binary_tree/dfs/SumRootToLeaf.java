package binary_tree.dfs;

import java.util.ArrayList;
import java.util.List;

public class SumRootToLeaf {

    private static TreeNode preorder(TreeNode root, int sum, List<Integer> list) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            list.add(((sum*10)+root.val));
        }

        preorder(root.left, ((sum*10)+root.val), list);
        preorder(root.right, ((sum*10)+root.val), list);
        return root;
    }

    private static int sum(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, 0, list);
        System.out.println(list);
        return list.stream().mapToInt(Integer::intValue).sum();
    }

    private static int preorder(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return (sum * 10) + root.val;
        }

        return preorder(root.left, ((sum * 10) + root.val)) + preorder(root.right, ((sum * 10) + root.val));
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(4, new TreeNode(9, new TreeNode(5), new TreeNode(1)), new TreeNode(0));
        System.out.println(preorder(tree, 0));
    }
}
