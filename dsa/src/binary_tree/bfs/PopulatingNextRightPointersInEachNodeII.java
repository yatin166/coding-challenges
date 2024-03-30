package binary_tree.bfs;

public class PopulatingNextRightPointersInEachNodeII {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode next;

        TreeNode() {}

        TreeNode(int val) { this.val = val; }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static TreeNode connect(TreeNode root) {
        while (root != null) {
            TreeNode dummyNode = new TreeNode();
            TreeNode currentNode = dummyNode;
            while (root != null) {
                if (currentNode.left != null) {
                    currentNode.next = currentNode.left;
                    currentNode = currentNode.next;
                }
                if (currentNode.right != null) {
                    currentNode.next = currentNode.right;
                    currentNode = currentNode.next;
                }
                root = root.next;
            }
            root = dummyNode.next;
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, null, new TreeNode(7)));
        System.out.println(connect(tree));
    }
}
