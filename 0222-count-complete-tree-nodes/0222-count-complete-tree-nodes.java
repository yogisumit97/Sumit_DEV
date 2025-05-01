class Solution {
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 2;
        while(q.size()!=0){
            int size = q.size();
            for(int i =0; i<size; i++){
                TreeNode curr = q.poll();
                if(curr.left!=null) q.offer(curr.left);
                else return level+q.size()-(size-i);
                if(curr.right!=null) q.offer(curr.right);
                else return level+q.size()-(size-i);
            }
            level = level<<1;
        }
        return 0;       
    }
}
