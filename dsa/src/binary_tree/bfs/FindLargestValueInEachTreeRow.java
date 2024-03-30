package binary_tree.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueInEachTreeRow {

    private static List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int maxElement = queue.peek().val;
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                maxElement = Math.max(currentNode.val, maxElement);

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            result.add(maxElement);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1, new TreeNode(3, new TreeNode(5), new TreeNode(3)), new TreeNode(2, null, new TreeNode(9)));
        System.out.println(largestValues(tree));
    }
}
