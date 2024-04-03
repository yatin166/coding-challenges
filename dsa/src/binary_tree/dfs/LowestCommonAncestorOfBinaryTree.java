package binary_tree.dfs;

public class LowestCommonAncestorOfBinaryTree {

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4)));
        TreeNode q = new TreeNode(8);
        TreeNode tree = new TreeNode(3, p, new TreeNode(1, new TreeNode(0), q));
        System.out.println(lowestCommonAncestor(tree, p, q).val);
    }
}
