class BSTIterator {
    int pointer;
    List<Integer> list;
    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        pointer = -1;
        inorder(root);
    }
    public void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
    public int next() {
        return list.get(++pointer);
    }
    
    public boolean hasNext() {
        if(pointer < list.size()-1 && list.size()!=0) return true;
        return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */