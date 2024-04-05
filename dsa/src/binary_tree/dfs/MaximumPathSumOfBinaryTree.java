package binary_tree.dfs;

public class MaximumPathSumOfBinaryTree {

    static int maxPath = Integer.MIN_VALUE;

    private static int maxPath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftValue = maxPath(root.left);
        int rightValue = maxPath(root.right);

        leftValue = Math.max(0, leftValue);
        rightValue = Math.max(0, rightValue);

        int currentPathValue = leftValue + rightValue + root.val;
        maxPath = Math.max(maxPath, currentPathValue);
        return Math.max(leftValue, rightValue) + root.val;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(-10, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        //TreeNode tree = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        maxPath(tree);
        System.out.println(maxPath);
    }
}
