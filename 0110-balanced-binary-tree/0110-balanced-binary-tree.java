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
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        return findBalancedOrNot(root)!=-1 ;
    }
    public int findBalancedOrNot(TreeNode curr){
        if(curr==null) return 0;
        int lh = findBalancedOrNot(curr.left);
        if(lh==-1) return -1;
        int rh = findBalancedOrNot(curr.right);
        if(rh== -1) return -1;
        if(Math.abs(lh-rh)>1) return -1;
        return 1+Math.max(lh,rh);
    }
}