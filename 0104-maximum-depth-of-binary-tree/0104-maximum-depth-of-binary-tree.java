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
    public int maxDepth(TreeNode root) {
        return maxHeight(root, 0);
    }
    private int maxHeight(TreeNode curr, int height){
        if(curr==null) return height;
        int currHeight = 0;
        currHeight = Math.max(maxHeight(curr.left, height+1), maxHeight(curr.right, height+1));
        return Math.max(height, currHeight);
    }
}