package recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

     public static class TreeNode {
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
     }

     private static List<List<Integer>> pathSum(TreeNode root, int targetSum, int ans, List<Integer> tempList) {

         if (root == null) {
             return List.of();
         }

         if (root.left == null && root.right == null && ans + root.val == targetSum) {
             tempList.add(root.val);
             List<List<Integer>> result = List.of(new ArrayList<>(tempList));
             tempList.remove(tempList.size() - 1);
             return result;
         }

         List<List<Integer>> result = new ArrayList<>();

         tempList.add(root.val);
         result.addAll(pathSum(root.left, targetSum, ans + root.val, tempList));
         result.addAll(pathSum(root.right, targetSum, ans + root.val, tempList));
         tempList.remove(tempList.size() - 1);

         return result;
     }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(11);
        node3.left = node1;
        node3.right = node2;
        TreeNode node4 = new TreeNode(4);
        node4.left = node3;
        TreeNode node5 = new TreeNode(5);
        node5.left = node4;
        TreeNode node6 = new TreeNode(8);
        node5.right = node6;
        TreeNode node7 = new TreeNode(13);
        node6.left = node7;
        TreeNode node8 = new TreeNode(4);
        node6.right = node8;
        TreeNode node9 = new TreeNode(5);
        TreeNode node10 = new TreeNode(1);
        node8.left = node9;
        node8.right = node10;

        System.out.println(pathSum(node5, 22, 0, new ArrayList<>()));
    }
}
