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
        List<String> result = new ArrayList<>();
        if(root==null) return result;
        List<List<Integer>> list = new ArrayList<>();
        pathFinder(root, new ArrayList<>(),list);
        for(List<Integer> path : list) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < path.size(); i++) {
                if(i != 0) sb.append("->");
                sb.append(path.get(i));
            }
            result.add(sb.toString());
        }
        return result;
    }
    private void pathFinder(TreeNode root, ArrayList<Integer> path, List<List<Integer>> list){
        if(root == null) return;
        path.add(root.val);

        if(root.left==null && root.right== null){
            list.add(new ArrayList<>(path));
        }
        else{
            pathFinder(root.left, path, list);
            pathFinder(root.right, path, list);
        }
        path.remove(path.size()-1);
    }
}