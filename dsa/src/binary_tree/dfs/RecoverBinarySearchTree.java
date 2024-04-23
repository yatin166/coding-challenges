package binary_tree.dfs;

public class RecoverBinarySearchTree {

    static TreeNode firstNode = null;
    static TreeNode secondNode = null;
    static TreeNode previousNode = new TreeNode(Integer.MIN_VALUE);
    static TreeNode previous = null;
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

    private static TreeNode helper(TreeNode node) {
        if (node == null) {
            return null;
        }

        helper(node.left);

        if (previous != null && previous.val > node.val) {
            if (firstNode == null) {
                firstNode = previous;
            }
            secondNode = node;
        }

        previous = node;

        helper(node.right);

        return node;
    }
    private static TreeNode recoverTreeUsingDFSAndClean(TreeNode root) {
        if (root == null) {
            return null;
        }

        helper(root);

        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;

        return root;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3, new TreeNode(1), new TreeNode(4, new TreeNode(2), null));
        System.out.println("BEFORE:");
        tree.printTree();
        System.out.println();
        TreeNode recoveredTree = recoverTreeUsingDFSAndClean(tree);
        System.out.println("AFTER:");
        recoveredTree.printTree();
    }
}
