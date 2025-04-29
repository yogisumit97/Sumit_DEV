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
    int maxSum;
    public int maxPathSum(TreeNode root) {
        if(root==null) return 0;
        maxSum = Integer.MIN_VALUE;
        maxSumFinder(root);
        return maxSum;
    }
    public int maxSumFinder(TreeNode root){
        if(root== null) return 0;
        int leftSum = maxSumFinder(root.left);
        int rightSum = maxSumFinder(root.right);
        maxSum = Math.max(maxSum, Math.max(Math.max(leftSum+rightSum+root.val, root.val), Math.max(root.val+leftSum, root.val+rightSum)));
        return Math.max(root.val, root.val+ Math.max(leftSum, rightSum));
    }
}