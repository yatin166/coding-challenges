package binary_tree.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeInZigzagOrderTraversal {

    private static List<List<Integer>> zigzagOrder(TreeNode root) {
        if (root == null) {
            return null;
        }

        List<List<Integer>> result = new ArrayList<>();

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isReversed = false;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentList = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                if (!isReversed) {
                    TreeNode currentNode = queue.pollFirst();
                    currentList.add(currentNode.val);
                    if (currentNode.left != null) {
                        queue.addLast(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        queue.addLast(currentNode.right);
                    }
                } else {
                    TreeNode currentNode = queue.pollLast();
                    currentList.add(currentNode.val);
                    if (currentNode.right != null) {
                        queue.addFirst(currentNode.right);
                    }
                    if (currentNode.left != null) {
                        queue.addFirst(currentNode.left);
                    }
                }
            }
            isReversed = !isReversed;
            result.add(currentList);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(zigzagOrder(tree));
    }
}
