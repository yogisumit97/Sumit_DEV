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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) return result;
        stack.push(root);
        int direction = 1;
        while(!stack.empty()){
            List<TreeNode> nodes = new ArrayList<>();
            while(!stack.empty()) nodes.add(stack.pop());
            List<Integer> l = new ArrayList<>();
            for(int i =0; i<nodes.size(); i++){
                l.add(nodes.get(i).val);
                if(direction == 1){
                    if(nodes.get(i).left != null) stack.push(nodes.get(i).left);
                    if(nodes.get(i).right != null) stack.push(nodes.get(i).right);
                }
                else if(direction == 0){
                    if(nodes.get(i).right != null) stack.push(nodes.get(i).right);
                    if(nodes.get(i).left != null) stack.push(nodes.get(i).left);
                }
            }
            direction^=1;
            result.add(l);
        }
        return result;
    }
}