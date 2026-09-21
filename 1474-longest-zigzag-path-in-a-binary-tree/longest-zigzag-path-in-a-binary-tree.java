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
    int ans=0;
    public int longestZigZag(TreeNode root) {
        solve(root);
        return ans;
    }
    int[] solve(TreeNode root){
        if(root==null){
            return new int[]{-1,-1};
        }
        int[]left=solve(root.left);
        int[]right=solve(root.right);
        int goleft=left[1]+1;
        int goright=right[0]+1;
        ans=Math.max(ans,Math.max(goleft,goright));
        return new int[]{goleft,goright};
    }
}