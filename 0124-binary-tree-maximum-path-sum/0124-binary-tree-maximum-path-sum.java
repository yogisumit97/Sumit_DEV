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
    private int maxSum;
    public int maxPathSum(TreeNode root) {
        if(root==null) return 0;
        maxSum = Integer.MIN_VALUE; 
        maxSumFinder(root);
        return maxSum;
    }
    public int maxSumFinder(TreeNode root){
        if(root== null) return 0;
        if(root.left==null && root.right==null){
            maxSum = Math.max(maxSum, root.val);
            return root.val;
        }
        int max = 0;
        if(root.left!=null && root.right!=null){
            int lh = maxSumFinder(root.left);
            int rh = maxSumFinder(root.right);
            max = Math.max(Math.max(lh+rh+root.val, root.val), Math.max(lh+root.val, rh+root.val));
            maxSum = Math.max(maxSum, max );
            return Math.max(root.val, Math.max(lh+root.val, rh+root.val));
        }
        else if(root.left == null){
            int rh = maxSumFinder(root.right);
            max = Math.max(Math.max(rh+root.val, root.val), rh);
            maxSum = Math.max(maxSum, max );
            return Math.max(root.val, rh+root.val);
        }
        else{
            int lh = maxSumFinder(root.left);
            max = Math.max(Math.max(lh+root.val, root.val), lh);
            maxSum = Math.max(maxSum, max );
            return Math.max(root.val, lh+root.val);
        }
    }
}