package binary_tree.dfs;

public class SumOfLeftLeaves {

    static int sum = 0;
    private static int sumOfLeftLeaves(TreeNode node) {
        if (node == null) {
            return 0;
        }

        if (node.left != null && node.left.left == null && node.left.right == null) {
            sum += node.left.val;
        }

        sumOfLeftLeaves(node.left);
        sumOfLeftLeaves(node.right);

        return sum;
    }

    public static void main(String[] args) {
        // TreeNode tree = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        // TreeNode tree = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        TreeNode tree = new TreeNode(1, new TreeNode(2), new TreeNode(4));
        System.out.println(sumOfLeftLeaves(tree));
    }
}
