package binary_tree.bfs;

public class CousinsInBinaryTree {

    private static boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xNode = findNode(root, x);
        TreeNode yNode = findNode(root, y);

        return ( level(root, xNode, 0) == level(root, yNode, 0) && !isSibling(root, xNode, yNode) );
    }

    private static TreeNode findNode(TreeNode node, int value) {
        if (node == null) {
            return null;
        }

        if (node.val == value) {
            return node;
        }

        TreeNode left = findNode(node.left, value);
        if (left != null) {
            return left;
        }
        return findNode(node.right, value);
    }

    private static int level(TreeNode root, TreeNode node, int level) {
        if (root == null) {
            return 0;
        }

        if (root == node) {
            return level;
        }

        int left = level(root.left, node, level + 1);
        if (left != 0) {
            return left;
        }
        return level(root.right, node, level + 1);
    }

    private static boolean isSibling(TreeNode node, TreeNode xNode, TreeNode yNode) {
        if (node == null) {
            return false;
        }

        return (
            (node.left == xNode && node.right == yNode) || 
            (node.left == yNode && node.right == xNode) || 
            isSibling(node.left, xNode, yNode) ||
            isSibling(node.right, xNode, yNode)
        );
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, null, new TreeNode(5)));
        System.out.println(isCousins(tree, 5, 4));
    }
}
