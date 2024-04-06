package binary_tree.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class CountAllPathsIncludingSubPathsForGivenTarget {

    private static int countPaths(TreeNode root, int target) {
        List<Integer> list = new ArrayList<>();
        return helper(root, target, list);
    }

    private static int helper(TreeNode node, int targetSum, List<Integer> list) {
        if (node == null) {
            return 0;
        }
        list.add(node.val);
        int count = 0;
        int sum = 0;
        // Check how many paths can be made with current list from previous
        ListIterator<Integer> itr = list.listIterator(list.size());
        while (itr.hasPrevious()) {
            int prevElement = itr.previous();
            sum += prevElement;

            if (sum == targetSum) {
                System.out.println(prevElement);
                count++;
            }
        }

        count += helper(node.left, sum, list) + helper(node.right, targetSum, list);

        // backtrack
        list.remove(list.size() - 1);
        return count;
    }

    // put in a list
    static List<List<Integer>> findPaths(TreeNode node, int sum) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(node, sum, path, paths);
        return paths;
    }

    static void helper(TreeNode node, int sum, List<Integer> path, List<List<Integer>> paths) {
        if(node == null) {
            return;
        }

        path.add(node.val);

        if (node.val == sum && node.left == null && node.right == null) {
            paths.add(new ArrayList<>(path));
        } else {
            helper(node.left, sum-node.val, path, paths);
            helper(node.right, sum-node.val, path, paths);
        }

        // backtrack
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1, new TreeNode(3, new TreeNode(11), null), new TreeNode(2, new TreeNode(1, new TreeNode(1), null), new TreeNode(3, new TreeNode(2, null, new TreeNode(2)), null)));
        System.out.println(findPaths(tree, 4));
        System.out.println(/*count*/);
    }
}
