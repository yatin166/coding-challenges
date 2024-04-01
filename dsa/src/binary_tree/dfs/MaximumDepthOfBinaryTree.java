package binary_tree.dfs;

public class MaximumDepthOfBinaryTree {

    static int ans = 0;

    private static int maxDepth(TreeNode root, int level) {
        if (root == null) {
            return level;
        }

        int leftLevel = maxDepth(root.left, level + 1);
        int rightLevel = maxDepth(root.right, level + 1);
        ans = Math.max(ans, Math.max(leftLevel, rightLevel));
        return 0;
    }

    public static void main(String[] args) {
        // TreeNode tree = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        TreeNode tree = new TreeNode(1, null, new TreeNode(2));
        maxDepth(tree, ans);
        System.out.println(ans);
    }
}
