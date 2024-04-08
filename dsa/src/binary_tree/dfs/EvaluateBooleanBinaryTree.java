package binary_tree.dfs;

public class EvaluateBooleanBinaryTree {

    static boolean evaulation = false;

    private static boolean evaulate(TreeNode node) {
        if (node == null) {
            return false;
        }

        if (node.left == null && node.right == null) {
            return node.val != 0;
        }

        boolean eval1 = evaulate(node.left);
        boolean eval2 = evaulate(node.right);
        if (node.val == 2) {
            return eval1 || eval2;
        }
        return eval1 && eval2;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(2, new TreeNode(1), new TreeNode(3, new TreeNode(0), new TreeNode(1)));
        // TreeNode tree = new TreeNode(0);
        System.out.println(evaulate(tree));
    }
}
