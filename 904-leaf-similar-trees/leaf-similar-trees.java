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
import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        
        getLeafSequence(root1, leaves1);
        getLeafSequence(root2, leaves2);
        
        return leaves1.equals(leaves2);
    }
    
    private void getLeafSequence(TreeNode node, List<Integer> leaves) {
        if (node == null) {
            return;
        }
        
        // If it's a leaf node, add its value to the list
        if (node.left == null && node.right == null) {
            leaves.add(node.val);
            return;
        }
        
        getLeafSequence(node.left, leaves);
        getLeafSequence(node.right, leaves);
    }
}