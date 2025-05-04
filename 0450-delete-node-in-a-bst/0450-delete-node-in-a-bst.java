class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return root;
        if(root.val == key){
            return helper(root);
        }
        TreeNode curr = root;
        while(curr!=null){
            if(curr.val > key){ // go left
                if(curr.left!=null && curr.left.val ==key){
                    curr.left = helper(curr.left);
                    return root;
                }
                else curr= curr.left;
            }
            else{ //go right
                if(curr.right!=null && curr.right.val ==key){
                    curr.right = helper(curr.right);
                    return root;
                }
                else curr= curr.right;
            }
        }
        return root;
    }
    private TreeNode helper(TreeNode root){
        if(root.left==null) return root.right;
        if(root.right==null) return root.left;
        TreeNode temp = root.left;
        while(temp.right!=null) temp = temp.right;
        temp.right = root.right;
        root.right = null;
        return root.left;
    }
}