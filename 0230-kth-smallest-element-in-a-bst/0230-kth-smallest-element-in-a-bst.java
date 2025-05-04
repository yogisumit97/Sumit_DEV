class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> inorder = new ArrayList<>();
        findInorder(root, inorder, k);
        return inorder.get(k-1);
    }
    public void findInorder(TreeNode root, List<Integer> inorder, int k){
        if(root == null) return;
        if(inorder.size()==k) return;
        findInorder(root.left, inorder, k);
        inorder.add(root.val);
        findInorder(root.right, inorder, k);
    }
}