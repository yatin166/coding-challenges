package binary_tree.dfs;

public class RecoverBinarySearchTree {

    static TreeNode firstNode = null;
    static TreeNode secondNode = null;
    static TreeNode previousNode = new TreeNode(Integer.MIN_VALUE);
    private static void findMistakenNodes(TreeNode root) {
        if (root == null) {
            return;
        }

        findMistakenNodes(root.left);

        if (firstNode == null && previousNode.val > root.val) {
            firstNode = previousNode;
        }

        if (firstNode != null && previousNode.val > root.val) {
            secondNode = root;
        }
        previousNode = root;

        findMistakenNodes(root.right);
    }

    private static TreeNode recoverTreeUsingDFS(TreeNode root) {
        if (root == null) {
            return null;
        }
        findMistakenNodes(root);

        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;

        return root;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3, new TreeNode(1), new TreeNode(4, new TreeNode(2), null));
        TreeNode recoveredTree = recoverTreeUsingDFS(tree);
        recoveredTree.printTree();
    }
}
