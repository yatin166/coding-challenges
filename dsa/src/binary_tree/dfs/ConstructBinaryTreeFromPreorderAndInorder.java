package binary_tree.dfs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorder {

    private static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }

        int root = preorder[0];
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root) {
                index = i;
            }
        }
        TreeNode node = new TreeNode(root);
        node.left = buildTree(Arrays.copyOfRange(preorder, 1, index + 1), Arrays.copyOfRange(inorder, 0, index));
        node.right = buildTree(Arrays.copyOfRange(preorder, index + 1, preorder.length), Arrays.copyOfRange(inorder, index + 1, inorder.length));
        return node;
    }

    // Using HashMap
    static int index = 0;
    private static TreeNode buildTreeUsingHashMapDFS(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, preorder.length - 1, map);
    }

    private static TreeNode helper(int[] preorder, int[] inorder, int left, int right, Map<Integer, Integer> map) {
        if (left > right) {
            return null;
        }
        int currentNodeVal = preorder[index];
        index++;
        TreeNode node = new TreeNode(currentNodeVal);
        if (left == right) {
            return node;
        }
        int inorderIndex = map.get(currentNodeVal);
        node.left = helper(preorder, inorder, left, inorderIndex - 1, map);
        node.right = helper(preorder, inorder, inorderIndex + 1, right, map);
        return node;
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode tree = buildTreeUsingHashMapDFS(preorder, inorder);
        tree.printTree();
    }
}
