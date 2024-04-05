package binary_tree.dfs;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SerializeAndDeserializeBinaryTree {

    private static TreeNode serialize(TreeNode root, StringBuilder str) {
        if (root == null) {
            str.append("null" + ",");
            return null;
        }
        str.append(root.val + ",");
        serialize(root.left, str);
        serialize(root.right, str);
        return root;
    }

    private static TreeNode deserialize(StringBuilder sb) {
        List<String> nodes = new java.util.ArrayList<>(Arrays.stream(sb.toString().split(",")).toList());
        Collections.reverse(nodes);
        return helper(nodes);
    }

    private static TreeNode helper(List<String> nodes) {
        String val = nodes.remove(nodes.size() - 1);
        if (val.equals("null")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = helper(nodes);
        node.right = helper(nodes);
        return node;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        StringBuilder sb = new StringBuilder();
        serialize(tree, sb);
        System.out.println(sb.toString());
        System.out.println();
        TreeNode deserialize = deserialize(sb);
        deserialize.printTree();
    }
}
