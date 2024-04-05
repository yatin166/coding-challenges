package binary_tree.dfs;

public class PathSum {

    private static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root .right == null && targetSum == root.val) {
            return true;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null), new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1))));
        //  TreeNode tree = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(hasPathSum(tree, 22));
    }
}
