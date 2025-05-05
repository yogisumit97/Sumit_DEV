class BSTIterator {
    Stack<TreeNode> stack;
    TreeNode temp;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushAll(root);
        temp = null;
    }
    public void pushAll(TreeNode root){
        if(root==null) return;
        stack.push(root);
        pushAll(root.left);
    }
    public int next() {
        temp = stack.pop();
        if(temp.right!=null) pushAll(temp.right);
        return temp.val;
    }
    
    public boolean hasNext() {
        if(stack.empty()) return false;
        return true;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */