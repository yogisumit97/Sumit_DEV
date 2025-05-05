class Solution {
    TreeNode first;
    TreeNode second;
    TreeNode middle;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        first = second = middle = prev = null;
        inorder(root);
        if(second==null) swap(first,middle);
        else swap(first, second);
    }
    private void swap(TreeNode a, TreeNode b){
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }
    private void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        if(prev!=null){
            if(prev.val > root.val){
                if(first ==null){
                    first = prev;
                    middle = root;
                }
                else second = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}