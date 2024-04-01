package binary_tree.dfs;


import java.util.ArrayList;
import java.util.List;

public class DiameterOfBinaryTree {

    static int diameter = 0;

    private static int diameter(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = diameter(node.left);
        int rightHeight = diameter(node.right);
        int dia = leftHeight + rightHeight + 1;
        diameter = Math.max(diameter, dia);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        //TreeNode tree = new TreeNode(1, new TreeNode(2), null);
        diameter(tree);
        System.out.println(diameter - 1);
    }
}
