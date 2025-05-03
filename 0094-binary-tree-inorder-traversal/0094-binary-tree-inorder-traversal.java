// morris inorder traversal O(1) space and O(N) time >> recursion takes O(N) for both.
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode curr = root;
        while(curr!=null){
            if(curr.left==null){
                list.add(curr.val);
                curr= curr.right;
            }
            else{
                TreeNode prev = curr.left;
                while(prev.right!=null && prev.right!=curr) prev = prev.right;
                if(prev.right==null){ // create link
                    prev.right = curr;
                    curr = curr.left;
                }
                else{ // link already exists, so remove link now.
                    prev.right = null;
                    list.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return list;
    }
}
