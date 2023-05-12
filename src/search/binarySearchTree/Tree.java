package search.binarySearchTree;

import nodes.TreeNode;

public class Tree<T extends Comparable<T>> {
    TreeNode<T> root;

    public Tree(T rootValue) {
        this.root = new TreeNode<>(rootValue);
    }

    // Inorder Traversal
    public void inorderTraversal(TreeNode<T> node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(" " + node.value);
            inorderTraversal(node.right);
        }
    }

    // Preorder Traversal
    public void preorderTraversal(TreeNode<T> node) {
        if (node != null) {
            System.out.print(" " + node.value);
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
    }

    // Postorder Traversal
    public void postorderTraversal(TreeNode<T> node) {
        if (node != null) {
            postorderTraversal(node.left);
            postorderTraversal(node.right);
            System.out.print(" " + node.value);
        }
    }

    // Utility functions to start traversal from root
    public void inorderTraversal() {
        inorderTraversal(root);
    }

    public void preorderTraversal() {
        preorderTraversal(root);
    }

    public void postorderTraversal() {
        postorderTraversal(root);
    }

    /**These methods are recursive.
     * For each method, if the passed-in node is not null, it recursively calls itself on the left child,
     * performs an action on the current node (printing the node's value in this case),
     * and then recursively calls itself on the right child. The order of these operations determines the type of traversal.

     The utility functions (inorderTraversal(), preorderTraversal(), postorderTraversal())
     are used to start the traversal from the root of the tree.*/

    public TreeNode<T> search(T value) {
        return search(root, value);
    }

    private TreeNode<T> search(TreeNode<T> node, T value) {
        if (node == null || value.equals(node.value)) {
            return node;
        }

        if (value.compareTo(node.value) < 0) {
            return search(node.left, value);
        } else {
            return search(node.right, value);
        }
    }

    public void insert(T value) {
        root = insert(root, value);
    }

    private TreeNode<T> insert(TreeNode<T> node, T value) {
        if (node == null) {
            return new TreeNode<>(value);
        }

        if (value.compareTo(node.value) < 0) {
            node.left = insert(node.left, value);
        } else if (value.compareTo(node.value) > 0) {
            node.right = insert(node.right, value);
        } else {
            // value is already present in the tree
            return node;
        }

        return node;
    }

    public void delete(T value) {
        root = delete(root, value);
    }

    private TreeNode<T> delete (TreeNode<T> node, T value) {
        if (node == null) {
            return null;
        }

        if (value.compareTo(node.value) < 0) {
            node.left = delete(node.left, value);
        } else if (value.compareTo(node.value) > 0) {
            node.right = delete(node.right, value);
        } else {
            // node with no leaf nodes
            if (node.left == null && node.right == null) {
                return null;
            } else if (node.left == null) {
                // node with one node (no left node)
                return node.right;
            } else if (node.right == null) {
                // node with one node (no right node)
                return node.left;
            } else {
                // nodes with two nodes
                // search for min number in right sub tree
                T minValue = findMinValue(node.right);
                node.value = minValue;
                node.right = delete(node.right, minValue);
            }
        }
        return node;
    }

    private T findMinValue(TreeNode<T> node) {
        if (node.left != null) {
            return findMinValue(node.left);
        }
        return node.value;
    }
}