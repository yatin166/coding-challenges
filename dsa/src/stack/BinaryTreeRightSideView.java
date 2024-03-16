package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class BinaryTreeRightSideView {

    private static List<Integer> binaryTreeRightSideViewUsingStack(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        Stack<TreeNode> stack3 = new Stack<>();
        stack1.push(root);
        while (root != null) {
            if (root.right != null || root.left != null) {
                while (!stack2.isEmpty()) {
                    stack3.push(stack2.pop());
                }
                while (!stack3.isEmpty()) {
                    TreeNode peek = stack3.peek();
                    if (peek.left != null) {
                        stack2.push(peek.left);
                    }
                    if (peek.right != null) {
                        stack2.push(peek.right);
                    }
                    stack3.pop();
                }
                if (root.right != null) {
                    if (root.left != null) {
                        stack2.push(root.left);
                    }
                    stack1.push(root.right);
                    root = root.right;
                } else if (root.left != null) {
                    stack1.push(root.left);
                    root = root.left;
                }
            } else {
                root = !stack2.isEmpty() ? stack2.pop() : null;
            }
        }

        int[] nodes = new int[stack1.size()];
        for (int i = nodes.length - 1; i >= 0; i--) {
            nodes[i] = stack1.pop().val;
        }
        return Arrays.stream(nodes).boxed().collect(Collectors.toList());
    }

    // Optimal solution
    private static void rightSideViewUsingRecursion(TreeNode root, List<Integer> resultList, int level) {
        if (root == null) {
            return;
        }

        if (level == resultList.size()) {
            resultList.add(root.val);
        }

        rightSideViewUsingRecursion(root.right, resultList, level + 1);
        rightSideViewUsingRecursion(root.left, resultList, level + 1);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1, null, new TreeNode(3, null, new TreeNode(4)));
        // System.out.println(binaryTreeRightSideViewUsingStack(node));

        List<Integer> result = new ArrayList<>();
        rightSideViewUsingRecursion(node, result, 0);
        System.out.println(result);
    }
}
