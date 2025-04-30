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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if(root==null) return list;
        pathFinder(root, list, "");
        return list;
    }
    private void pathFinder(TreeNode root, List<String> list, String sb){
        if(root.left ==null && root.right==null){
            sb+= sb.length()>0 ? "->"+root.val : ""+root.val ;
            list.add(sb);
            return;
        }
        if(sb.length()==0) sb+=""+root.val;
        else sb+="->"+root.val;
        if(root.left!=null) pathFinder(root.left, list, sb);
        if(root.right!=null) pathFinder(root.right, list, sb);
    }
}