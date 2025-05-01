class Solution {
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int total = 0;
        while(q.size()!=0){
            int size = q.size();
            for(int i =0; i<size; i++){
                TreeNode curr = q.poll();
                total+=1;
                if(curr.left!=null){
                    q.offer(curr.left);
                }
                else return total+q.size();
                if(curr.right!=null){
                    q.offer(curr.right);
                }
                else return total+q.size();
            }
        }
        return total;       
    }
}
