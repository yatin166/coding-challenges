package binary_tree.bfs;

public class PopulatingNextRightPointersInEachNode {

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
        if (root == null) {
            return root;
        }

        TreeNode leftMost = root;
        while (leftMost.left != null) {
            TreeNode currentNode = leftMost;
            while (currentNode != null) {
                currentNode.left.next = currentNode.right;
                if (currentNode.next != null) {
                    currentNode.right.next = currentNode.next.left;
                }
                currentNode = currentNode.next;
            }
            leftMost = leftMost.left;
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        System.out.println(connect(tree));
    }
}
