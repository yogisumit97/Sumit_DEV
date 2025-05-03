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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        for(int i=0; i<inorder.length; i++) inorderMap.put(inorder[i], i);
        return bTHelper(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1, inorderMap);
    }
    private TreeNode bTHelper(int[] preorder, int[] inorder, int ip, int jp, int ii, int ij, HashMap<Integer,Integer> inordermap){
        if(ip > jp || ii> ij) return null;
        TreeNode curr = new TreeNode(preorder[ip]);
        int currIndex = inordermap.get(preorder[ip]);
        curr.left = bTHelper(preorder, inorder, ip+1, ip+currIndex-ii, ii, currIndex-1, inordermap);
        curr.right = bTHelper(preorder, inorder, ip+currIndex-ii+1, jp,currIndex+1, ij, inordermap);
        return curr;
    }
}