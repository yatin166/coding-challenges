package binary_tree;

import java.util.Scanner;

public class CustomBinaryTreeImplementation {

    private static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node root;

    public CustomBinaryTreeImplementation() {
    }

    public void populate(Scanner scanner) {
        System.out.println("Enter root node value: ");
        int value = scanner.nextInt();
        root = new Node(value);
        populate(scanner, root);
    }

    private void populate(Scanner scanner, Node node) {
        System.out.println("Do you want create left node for Node: " + node.val);
        boolean left = scanner.nextBoolean();
        if (left) {
            System.out.println("Enter the left node value: ");
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner, node.left);
        }

        System.out.println("Do you want to create right node for Node: " + node.val);
        boolean right = scanner.nextBoolean();
        if (right) {
            System.out.println("Enter the right node value: ");
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner, node.right);
        }
    }

    private void display() {
        // display(root, "");
        prettyDisplay(root, 0);
    }

    private void display(Node node, String indent) {
        if (node == null) {
            return;
        }

        System.out.println(indent + node.val);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
    }

    private void prettyDisplay(Node node, int level) {
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomBinaryTreeImplementation binaryTree = new CustomBinaryTreeImplementation();
        binaryTree.populate(scanner);
        binaryTree.display();
    }
}
