package binary_tree.dfs;

public class MinimumDepthOfBinaryTree {

    private static int minimumDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = minimumDepth(node.left);
        int right = minimumDepth(node.right);

        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }

    public static void main(String[] args) {
        //TreeNode tree = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        TreeNode tree = new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4, null, new TreeNode(5, null, new TreeNode(6)))));
        //TreeNode tree = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(22), null), new TreeNode(4, new TreeNode(9, new TreeNode(10), null), null)), new TreeNode(3, new TreeNode(6), new TreeNode(7, null, new TreeNode(8))));
        //TreeNode tree = new TreeNode(1, new TreeNode(2), null);
        System.out.println(minimumDepth(tree));
    }
}
