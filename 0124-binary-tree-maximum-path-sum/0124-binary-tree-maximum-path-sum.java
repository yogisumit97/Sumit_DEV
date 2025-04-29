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
        int max = 0;
        int lh = maxSumFinder(root.left);
        int rh = maxSumFinder(root.right);
        if(lh ==0 && rh ==0){
            max = root.val;
            maxSum = Math.max(maxSum, max);
        }
        else if(lh ==0){ // discard left half
            max = Math.max(root.val, rh+root.val);
            maxSum = Math.max(maxSum, max );
        }
        else if(rh ==0){
            max = Math.max(root.val, lh+root.val);
            maxSum = Math.max(maxSum, max );
        }
        else{
            max = Math.max(root.val, Math.max(lh+root.val, rh+root.val));
            int temp = Math.max(lh+rh+root.val, max);
            maxSum = Math.max(maxSum, temp);
        }
        return max;
    }
}