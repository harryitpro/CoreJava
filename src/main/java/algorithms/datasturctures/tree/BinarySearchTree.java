package algorithms.datasturctures.tree;

import algorithms.datasturctures.TreeNode;

public class BinarySearchTree {
    private TreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    //APIs:
    //insert, search, delete, iterate
    public void insert(int data) {
        //use recursive method to insert:
        TreeNode TreeNode = new TreeNode(data);
        root = insert(root, TreeNode);
    }

    private TreeNode insert(TreeNode subRoot, TreeNode TreeNode) {
        if (subRoot == null) {
            subRoot = TreeNode;
            return subRoot;
        }
        if (TreeNode.val < subRoot.val) {
            subRoot.left = insert(subRoot.left, TreeNode);
        } else if (TreeNode.val > subRoot.val) {
            subRoot.right = insert(subRoot.right, TreeNode);
        }
        return subRoot;
    }

    // Inorder traversal (Left, Root, Right)
    public void inorder() {
        System.out.print("Inorder traversal: ");
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(TreeNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.val + " ");
            inorderRec(root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Insert values
        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int value : values) {
            bst.insert(value);
        }

        bst.inorder();    // Should print: 20 30 40 50 60 70 80
    }
}
