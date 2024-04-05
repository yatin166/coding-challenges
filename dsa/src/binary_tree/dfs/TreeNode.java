package binary_tree.dfs;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) { this.val = val; }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void prettyDisplay() {
        prettyDisplay(this, 0);
    }

    private static void prettyDisplay(TreeNode node, int level) {
        if (node == null) {
            return;
        }

        prettyDisplay(node.right, level + 1);

        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|------>" + node.val);
        } else {
            System.out.println(node.val);
        }
        prettyDisplay(node.left, level + 1);
    }
    private int heightOfTree(TreeNode root, int level) {
        if (root == null) {
            return level;
        }

        int leftHeight = heightOfTree(root.left, level + 1);
        int rightHeight = heightOfTree(root.right, level + 1);

        return Math.max(leftHeight, rightHeight);
    }

    private List<List<String>> getListStructure(int height) {

        List<List<String>> ans = new ArrayList<>();
        int rows = height + 1;
        int cols = (int) Math.pow(2, rows) - 1;
        for (int i = 0; i < rows; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                list.add("*");
            }
            ans.add(list);
        }
        return ans;
    }

    private void constructTreeStructureInList(TreeNode node, List<List<String>> list, int parentRow, int parentCol, int heightOfTree) {
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

    private static void print(List<List<String>> tree) {
        for (List<String> row : tree) {
            for (String node : row) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }

    public void printTree() {
        int height = heightOfTree(this, 0) - 1;
        List<List<String>> list = getListStructure(height);
        int row = 0;
        int col = list.get(0).size() / 2;
        list.get(row).set(col, String.valueOf(this.val));
        constructTreeStructureInList(this, list, row, col, height);
        print(list);
    }
}
