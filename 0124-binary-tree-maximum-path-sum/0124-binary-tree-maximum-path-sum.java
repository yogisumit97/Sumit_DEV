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
        int leftSum = Math.max(0, maxSumFinder(root.left)); // if less than 0 dont take this path
        int rightSum = Math.max(0, maxSumFinder(root.right));
        maxSum = Math.max(maxSum, leftSum+rightSum+root.val);
        return root.val+ Math.max(leftSum, rightSum); // discard if less than 0
    }
}