/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        
        // If current node's value is less than low, the left subtree can be pruned
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        
        // If current node's value is greater than high, the right subtree can be pruned
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        
        // If current node's value is within the range, include it and check both subtrees
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
}