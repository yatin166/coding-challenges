package binary_tree.dfs;

public class LowestCommonAncestorOfBinarySearchTree {

    // Optimized
    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while ((root.val - p.val) * (root.val - q.val) > 0)
            root = p.val < root.val ? root.left : root.right;
        return root;
    }



    public static void main(String[] args) {

    }
}
