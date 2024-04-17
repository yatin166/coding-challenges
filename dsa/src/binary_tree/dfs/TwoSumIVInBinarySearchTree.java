package binary_tree.dfs;

import java.util.HashSet;
import java.util.Set;

public class TwoSumIVInBinarySearchTree {

    static Set<Integer> set = new HashSet<>();

    private static boolean findTarget(TreeNode node, int k) {
        if (node == null) {
            return false;
        }

        if (set.contains(k - node.val)) {
            return true;
        } else {
            set.add(node.val);
        }

        return findTarget(node.left, k) || findTarget(node.right, k);
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(4)), new TreeNode(6, null, new TreeNode(7)));
        System.out.println(findTarget(tree, 9));
    }
}
