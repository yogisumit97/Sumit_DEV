class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Stack<TreeNode> nextStack = new Stack<>();
        Stack<TreeNode> prevStack = new Stack<>();
        pushAll(root, nextStack, 0);
        pushAll(root, prevStack, 1);
        while(!nextStack.empty() && !prevStack.empty() && nextStack.peek()!= prevStack.peek()){
            int sum = nextStack.peek().val + prevStack.peek().val;
            if(sum ==k) return true;
            else if(sum < k){
                TreeNode temp = nextStack.pop();
                pushAll(temp.right, nextStack, 0);
            }
            else{
                TreeNode temp = prevStack.pop();
                pushAll(temp.left, prevStack, 1);
            }
        }
        return false;
    }
    private void pushAll(TreeNode root, Stack<TreeNode> nextStack, int isRight){
        while(root!=null){
            nextStack.push(root);
            root = isRight==0? root.left : root.right;
        }
    }
}