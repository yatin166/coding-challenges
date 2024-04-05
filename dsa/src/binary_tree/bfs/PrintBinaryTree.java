package binary_tree.bfs;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class PrintBinaryTree {

    private static List<List<String>> printBinaryTree(TreeNode root) {
        if (root == null) {
            return List.of(List.of(""));
        }

        int height = heightOfTree(root, 0) - 1;
        List<List<String>> list = getListStructure(height);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        Map<TreeNode, Integer[]> location = new LinkedHashMap<>();
        int row = 0;
        int col = list.get(0).size() / 2;
        location.put(root, new Integer[]{row, col});
        list.get(row).set(col, String.valueOf(root.val));

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentParent = queue.poll();
                Integer[] parentLocation = location.get(currentParent);
                int parentRow = parentLocation[0];
                int parentCol = parentLocation[1];
                if (currentParent.left != null) {
                    queue.add(currentParent.left);
                    int newRow = parentRow + 1;
                    int newCol = (int) (parentCol - Math.pow(2, (height - parentRow - 1)));
                    location.put(currentParent.left, new Integer[]{newRow, newCol});
                    list.get(newRow).set(newCol, String.valueOf(currentParent.left.val));
                }
                if (currentParent.right != null) {
                    queue.add(currentParent.right);
                    int newRow = parentRow + 1;
                    int newCol = (int) (parentCol + Math.pow(2, (height - parentRow - 1)));
                    location.put(currentParent.right, new Integer[]{newRow, newCol});
                    list.get(newRow).set(newCol, String.valueOf(currentParent.right.val));
                }
            }
        }

        print(list);
        return list;
    }

    private static int heightOfTree(TreeNode root, int level) {
        if (root == null) {
            return level;
        }

        int leftHeight = heightOfTree(root.left, level + 1);
        int rightHeight = heightOfTree(root.right, level + 1);

        return Math.max(leftHeight, rightHeight);
    }

    private static List<List<String>> getListStructure(int height) {

        List<List<String>> ans = new ArrayList<>();
        int rows = height + 1;
        int cols = (int) Math.pow(2, rows) - 1;
        for (int i = 0; i < rows; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                list.add("-");
            }
            ans.add(list);
        }
        return ans;
    }

    private static void constructTreeStructureInList(TreeNode node, List<List<String>> list, int parentRow, int parentCol, int heightOfTree) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            int newRow = parentRow + 1;
            int newCol = (int) (parentCol - Math.pow(2, (heightOfTree - parentRow - 1)));
            list.get(newRow).set(newCol, String.valueOf(node.left.val));
            constructTreeStructureInList(node.left, list, newRow, newCol, heightOfTree);
        }
        if (node.right != null) {
            int newRow = parentRow + 1;
            int newCol = (int) (parentCol + Math.pow(2, (heightOfTree - parentRow - 1)));
            list.get(newRow).set(newCol, String.valueOf(node.right.val));
            constructTreeStructureInList(node.right, list, newRow, newCol, heightOfTree);
        }
    }

    private static void printTree(TreeNode root) {
        int height = heightOfTree(root, 0) - 1;
        List<List<String>> list = getListStructure(height);
        int row = 0;
        int col = list.get(0).size() / 2;
        list.get(row).set(col, String.valueOf(root.val));
        constructTreeStructureInList(root, list, row, col, height);
        print(list);
    }

    private static void print(List<List<String>> tree) {
        for (int i = 0; i < tree.size(); i++) {
            System.out.print(tree.get(i));
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1, new TreeNode(2, new TreeNode(9), new TreeNode(4)), new TreeNode(3, null, new TreeNode(20)));
        printTree(tree);
    }
}
