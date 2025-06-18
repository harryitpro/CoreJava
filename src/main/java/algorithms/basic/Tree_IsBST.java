package algorithms.basic;

/**
 * Binary search tree validator in java
 */

/**
 * Let’s implement a Binary Search Tree (BST) validator in Java. A BST has a specific property: for any node, all values in the left subtree must be less than the node’s value, and all values in the right subtree must be greater than the node’s value. We’ll create a solution to check if a given binary tree satisfies this property.
 * <p>
 * Approach
 * To validate a BST:
 * <p>
 * Recursive Validation with Range:
 * For each node, maintain a valid range of values (min and max) that the node’s value must fall within.
 * The root can have any value (initially
 * −
 * ∞
 * −∞ to
 * +
 * ∞
 * +∞).
 * For a left child, the max value is the parent’s value.
 * For a right child, the min value is the parent’s value.
 * Recursively check all nodes.
 * Handle Edge Cases:
 * Null nodes are valid (empty tree or leaf’s children).
 * Integer overflow must be considered, so we’ll use Long for min/max bounds.
 * Alternative (Inorder Traversal):
 * An inorder traversal of a BST should yield values in ascending order. We could track the previous value and compare, but the range-based approach is more robust and handles duplicates appropriately.
 * Below is the Java implementation using the range-based recursive approach.
 */


public class Tree_IsBST {
    public boolean isValidBST(TreeNode root) {
        return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean validate(TreeNode node, int min, int max) {
        //base condition
        if (node == null) {
            return true; // Base case
        }
        System.out.println("processing node.value = " + node.val);
        if (node.val <= min || node.val >= max) {
            return false;
        }

        //pass parent's data to be MAX argument for left subtree
        boolean isValid = validate(node.left, min, node.val);
        if (isValid == false) {
            return false;
        }

        //pass parent's data to be MIN argument for right subtree
        isValid = validate(node.right, node.val, max);

        return isValid;
    }

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);

        TreeNode leftChild = new TreeNode(3);
        root.left = leftChild;

        TreeNode rightChild = new TreeNode(6);
        root.right = rightChild;

        leftChild.left = new TreeNode(2);
        leftChild.right = new TreeNode(8);

        Tree_IsBST validator = new Tree_IsBST();
        System.out.println("is it valid: " + validator.isValidBST(root)); // Output: true
    }
}

