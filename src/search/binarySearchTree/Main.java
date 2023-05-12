package search.binarySearchTree;

import nodes.TreeNode;

public class Main {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>(8);
        tree.root.left = new TreeNode<>(3);
        tree.root.right = new TreeNode<>(10);
        tree.root.left.left = new TreeNode<>(1);
        tree.root.left.right = new TreeNode<>(6);
        tree.root.left.right.left = new TreeNode<>(4);
        tree.root.left.right.right = new TreeNode<>(7);
        tree.root.right.right = new TreeNode<>(14);
        tree.root.right.right.left = new TreeNode<>(13);

        System.out.println("Preorder traversal:");
        tree.preorderTraversal();  // Expected Output: 8 3 1 6 4 7 10 14 13

        System.out.println("\nInorder traversal:");
        tree.inorderTraversal();   // Expected Output: 1 3 4 6 7 8 10 13 14

        System.out.println("\nPostorder traversal:");
        tree.postorderTraversal(); // Expected Output: 1 4 7 6 3 13 14 10 8

        TreeNode<Integer> resultX = tree.search(7);
        if (resultX != null) {
            System.out.println("\nFound 7 in the tree. Node: " + resultX.value);
        } else {
            System.out.println("\nDid not find 7 in the tree");
        }

        TreeNode<Integer> resultY = tree.search(20);
        if (resultY != null) {
            System.out.println("\nFound 20 in the tree. Node: " + resultY.value);
        } else {
            System.out.println("\nDid not find 20 in the tree");
        }

        tree.insert(20);

        System.out.println("\nInorder traversal after inserting 20:");
        tree.inorderTraversal(); // Expected output: 1 3 4 6 7 8 10 13 14 20

        tree.delete(4);
        System.out.println("\nInorder traversal after deleting 4:");
        tree.inorderTraversal();

        tree.delete(14);
        System.out.println("\nInorder traversal after deleting 14:");
        tree.inorderTraversal();

        tree.delete(8);
        System.out.println("\nInorder traversal after deleting 8:");
        tree.inorderTraversal();
    }
}

/**
 *     8
 *    / \
 *   3   10
 *  / \    \
 * 1   6    14
 *    / \   /
 *   4   7 13
 */
