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
    public List<Integer> postorderTraversal(TreeNode root) { // approach using 2 stacks
        Stack<TreeNode> iterationStack = new Stack<>();
        Stack<Integer> resultStack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        iterationStack.push(root);
        while(!iterationStack.empty()){
            TreeNode curr = iterationStack.pop();
            resultStack.push(curr.val);
            if(curr.left!=null) iterationStack.push(curr.left);
            if(curr.right!=null) iterationStack.push(curr.right);
        }
        while(!resultStack.empty()){
            result.add(resultStack.pop());
        }
        return result;
    }
}