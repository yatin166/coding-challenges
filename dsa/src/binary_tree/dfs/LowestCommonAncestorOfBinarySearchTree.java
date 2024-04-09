package binary_tree.dfs;

public class LowestCommonAncestorOfBinarySearchTree {

    // Optimized
    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while ((root.val - p.val) * (root.val - q.val) > 0)
            root = p.val < root.val ? root.left : root.right;
        return root;
    }

    private static TreeNode lowestCommonAncestorUsingDFS(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestorUsingDFS(root.left, p, q);
        TreeNode right = lowestCommonAncestorUsingDFS(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left == null ? right : left;
    }

    public static void main(String[] args) {
        TreeNode q = new TreeNode(4, new TreeNode(3), new TreeNode(5));
        TreeNode p = new TreeNode(2, new TreeNode(0), q);
        TreeNode tree = new TreeNode(6, p, new TreeNode(8, new TreeNode(7), new TreeNode(9)));
        System.out.println(lowestCommonAncestor(tree, p, q).val);
    }
}
