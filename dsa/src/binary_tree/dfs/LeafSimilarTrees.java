package binary_tree.dfs;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {

    private static boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    private static void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        if (isLeaf(root)) {
            list.add(root.val);
            return;
        }

        dfs(root.left, list);
        dfs(root.right, list);
    }

    private static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 != null) {
            return false;
        }
        if (root1 != null && root2 == null) {
            return false;
        }
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        dfs(root1, list1);
        dfs(root2, list2);

        return list1.equals(list2);
    }

    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(3, new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))), new TreeNode(1, new TreeNode(9), new TreeNode(8)));
        TreeNode tree2 = new TreeNode(3, new TreeNode(5, new TreeNode(6), new TreeNode(7)), new TreeNode(1, new TreeNode(4), new TreeNode(2, new TreeNode(9), new TreeNode(8))));
        tree1.printTree();
        System.out.println();
        tree2.printTree();
        System.out.println(leafSimilar(tree1, tree2));
    }
}
