package binary_tree.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KthSmallestElementInBinarySearchTree {


    int counter = 0;
    static int k;
    static int result;

    // Average solution using list
    private static TreeNode allNodes(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return null;
        }

        allNodes(node.left, list);
        list.add(node);
        allNodes(node.right, list);
        return node;
    }

    public int kthSmallestUsingList(TreeNode root, int k) {
        List<TreeNode> list = new ArrayList<>();
        allNodes(root, list);
        return list.get(k - 1).val;
    }

    // Average solution using heap
    private static int kthSmallestNodeUsingHeapAndDFS(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }

        PriorityQueue<Integer> meanHeap = new PriorityQueue<>();
        inorderTraversal(root, meanHeap);

        int ans = 0;
        for (int i = 0; i < k; i++) {
            ans = meanHeap.poll();
        }
        return ans;
    }

    private static TreeNode inorderTraversal(TreeNode node, PriorityQueue<Integer> minHeap) {
        if (node == null) {
            return null;
        }

        inorderTraversal(node.left, minHeap);
        minHeap.offer(node.val);
        inorderTraversal(node.right, minHeap);
        return node;
    }

    // Most optimized solution
    private TreeNode kthSmallestNodeUsingRecursionDFS(TreeNode root, int k) {
        if (root == null) {
            return null;
        }

        TreeNode left = this.kthSmallestNodeUsingRecursionDFS(root.left, k);
        if (left != null) {
            return left;
        }
        this.counter++;
        if (this.counter == k) {
            return root;
        }

        return this.kthSmallestNodeUsingRecursionDFS(root.right, k);
    }

    // Most optimized and clean solution
    private static int kthSmallestNodeUsingRecursionDFSClean(TreeNode root, int kth) {
        k = kth;
        helperInorderTraversal(root);
        return result;
    }

    private static void helperInorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        helperInorderTraversal(root.left);

        k--;
        if (k == 0) {
            result = root.val;
            return;
        }

        helperInorderTraversal(root.right);
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(5, new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4)), new TreeNode(6));
        System.out.println(kthSmallestNodeUsingRecursionDFSClean(tree, 4));
    }
}
