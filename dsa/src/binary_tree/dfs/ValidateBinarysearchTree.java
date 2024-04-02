package binary_tree.dfs;

public class ValidateBinarysearchTree {

    private static boolean isValid(TreeNode node, Integer lower, Integer higher) {
        if (node == null) {
            return true;
        }

        if (lower != null && node.val <= lower) {
            return false;
        }

        if (higher != null && node.val >= higher) {
            return false;
        }

        return isValid(node.left, lower, node.val) && isValid(node.right, node.val, higher);
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)));
        System.out.println(isValid(tree, null, null));
    }
}
