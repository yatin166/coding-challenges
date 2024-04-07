package binary_tree.dfs;

public class MergeTwoBinaryTrees {

    private static TreeNode mergeTreesUsingDFS(TreeNode root1, TreeNode root2, TreeNode finalTree) {
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 != null && root2 == null) {
            return root1;
        }
        if (root1 == null && root2 != null) {
            return root2;
        }
        finalTree = new TreeNode(root1.val + root2.val);
        finalTree.left = mergeTreesUsingDFS(root1.left, root2.left, finalTree);
        finalTree.right = mergeTreesUsingDFS(root1.right, root2.right, finalTree);
        return finalTree;
    }

    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(1, new TreeNode(3, new TreeNode(5), null), new TreeNode(2));
        TreeNode tree2 = new TreeNode(2, new TreeNode(1, null, new TreeNode(4)), new TreeNode(3, null, new TreeNode(7)));
        TreeNode mergedTree = null;
        mergedTree = mergeTreesUsingDFS(tree1, tree2, mergedTree);
        mergedTree.printTree();
    }
}
