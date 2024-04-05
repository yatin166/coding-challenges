package binary_tree.dfs;


public class ConvertSortedArrayToBST {

    static TreeNode root = null;

    private static TreeNode insert(int val, TreeNode node) {
        if (node == null) {
            node = new TreeNode(val);
            return node;
        }

        if (val <= node.val) {
            node.left = insert(val, node.left);
        }

        if (val > node.val) {
            node.right = insert(val, node.right);
        }

        return node;
    }

    private static void populate(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;
        root = insert(arr[mid], root);
        populate(arr, start, mid);
        populate(arr, mid + 1, end);
    }

    public static void main(String[] args) {
        //int[] arr = new int[] {-10, -3, 0, 5, 9};
        int[] arr = new int[] {1,2,3,4,5,6,8,9,18};
        populate(arr, 0, arr.length);
        root.printTree();
    }
}
