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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>(); 
        if(root==null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(queue.size()!=0){
            List<Integer> l = new ArrayList<>();
            int len = queue.size();
            for(int i=0; i<len; i++){
                TreeNode currRoot = queue.poll();
                l.add(currRoot.val);
                if(currRoot.left!=null) queue.offer(currRoot.left);
                if(currRoot.right!=null) queue.offer(currRoot.right);
                //System.out.println(currRoot.val + "   "+ l);
            }
            list.add(l);
            //System.out.println(l);
        }
        return list;
    }
}