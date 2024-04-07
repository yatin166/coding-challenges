package binary_tree.dfs;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    private static void allPaths(TreeNode node, List<String> list, String str) {

        if (node.left == null && node.right == null)
            list.add(str + node.val);

        if (node.left != null)
            allPaths(node.left, list, str + node.val + "->");
        if (node.right != null)
            allPaths(node.right, list, str + node.val + "->");
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3));
        //TreeNode tree = new TreeNode(1);
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        allPaths(tree, list, "");
        System.out.println(list);
    }
}
