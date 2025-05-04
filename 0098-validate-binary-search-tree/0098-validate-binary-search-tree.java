class Solution {
    public boolean isValidBST(TreeNode root) {
        return bstValidHelper(root, (long)(Integer.MIN_VALUE)-1, (long)(Integer.MAX_VALUE)+1);
    }
    public boolean bstValidHelper(TreeNode root, long min, long max){
        if(root ==null) return true;
        if(min>=root.val ||max<=root.val) return false;
        return bstValidHelper(root.left, min, root.val) && bstValidHelper(root.right, root.val, max);
    }
}