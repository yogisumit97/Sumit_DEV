class Solution {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        int left = 0;
        int right = list.size()-1;
        while(left<right){
            int currSum = list.get(left)+list.get(right);
            if(currSum == k) return true;
            else if(currSum > k) right = right-1;
            else left = left+1;
        }
        return false;
    }
    private void inorder(TreeNode root, List<Integer> list){
        if(root==null) return;
        inorder(root.left , list);
        list.add(root.val);
        inorder(root.right, list);
    }
}