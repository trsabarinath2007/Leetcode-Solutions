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
    static int leftcount=0;
    static int rightcount=0;
    public static int count(TreeNode root,int x){
        if(root==null){
            return 0;
        }
        int left=count(root.left,x);
        int right=count(root.right,x);
        if(root.val==x){
            leftcount=left;
            rightcount=right;
        }
        return left+right+1;
    }
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        count(root,x);
        int parentside=n-leftcount-rightcount-1;
        int max=Math.max(parentside,Math.max(leftcount,rightcount));
        return max>n/2;
    }
}