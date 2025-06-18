package algorithms.complex;

import algorithms.basic.datasturctures.TreeNode;

/**
 * the LCA of two nodes p and q is the deepest (lowest) node that has both p and q as descendants
 */

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // If root is null, return null
        if (root == null) {
            return null;
        }

        // If both p and q are greater than root, LCA is in the right subtree
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        // If both p and q are smaller than root, LCA is in the left subtree
        else if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        // If one is smaller and the other is larger, or one equals root,
        // then the current root is the LCA
        else {
            return root;
        }
    }

    // Helper method to test the solution
    public static void main(String[] args) {
        LowestCommonAncestor solution = new LowestCommonAncestor();

        // Create a sample BST:
        //       6
        //      / \
        //     2   8
        //    / \ / \
        //   0  4 7  9
        //     / \
        //    3   5

        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        // Test case 1: LCA of 2 and 8
        TreeNode p = root.left; // 2
        TreeNode q = root.right; // 8
        TreeNode lca = solution.lowestCommonAncestor(root, p, q);
        System.out.println("LCA of 2 and 8 is: " + lca.val); // Should print 6

        // Test case 2: LCA of 2 and 4
        p = root.left; // 2
        q = root.left.right; // 4
        lca = solution.lowestCommonAncestor(root, p, q);
        System.out.println("LCA of 2 and 4 is: " + lca.val); // Should print 2

        // Test case 3: LCA of 3 and 5
        p = root.left.right.left; // 3
        q = root.left.right.right; // 5
        lca = solution.lowestCommonAncestor(root, p, q);
        System.out.println("LCA of 3 and 5 is: " + lca.val); // Should print 4
    }
}
