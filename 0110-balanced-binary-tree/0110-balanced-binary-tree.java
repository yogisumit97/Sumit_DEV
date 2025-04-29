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
        int lh = findHeight(root.left,0);
        int rh = findHeight(root.right,0);    
        if(Math.abs(lh-rh)>1) return false;
        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);
        if(left==false || right == false) return false;
        return true;
    }
    public int findHeight(TreeNode curr, int height){
        if(curr==null) return height;
        int currHeight = 0;
        currHeight = Math.max(findHeight(curr.left, height+1), findHeight(curr.right, height+1));
        return Math.max(height, currHeight);
    }
}