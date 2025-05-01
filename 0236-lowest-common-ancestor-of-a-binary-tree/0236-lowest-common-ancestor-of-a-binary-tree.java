/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return root;
        List<TreeNode> pPath  = new ArrayList<>();
        List<TreeNode> qPath  = new ArrayList<>();
        traverseTree(root, p, q, pPath, qPath, new int[]{1,1});
        int count = 1;
        TreeNode ans = root;
        while(count< pPath.size() && count< qPath.size()){
            if(pPath.get(count)!= qPath.get(count)) break;
            else ans = pPath.get(count);
            count++;
        }
        return ans;
    }
    public void traverseTree(TreeNode root,TreeNode p,TreeNode q, List<TreeNode> pPath,List<TreeNode> qPath, int[] pcAndQc){
        if(root==null) return;
        if(pcAndQc[0]==1){
            pPath.add(root);
            if(root==p) pcAndQc[0] = 0;
        }
        if(pcAndQc[1]==1){
            qPath.add(root);
            if(root==q) pcAndQc[1] = 0;
        }
        if((pcAndQc[0]|pcAndQc[1]) ==0) return;
        else{
            traverseTree(root.left, p,q, pPath, qPath, pcAndQc);
            traverseTree(root.right, p,q, pPath, qPath, pcAndQc);
        }
        if(pcAndQc[0]!=0) pPath.remove(pPath.size()-1);
        if(pcAndQc[1]!=0) qPath.remove(qPath.size()-1);
    }
}