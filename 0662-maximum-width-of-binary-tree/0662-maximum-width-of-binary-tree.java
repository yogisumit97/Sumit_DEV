class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair<TreeNode,Integer>> queue = new LinkedList<>();
        if(root==null) return 0;
        queue.offer(new Pair<>(root, 0));
        int width = 0;
        while(queue.size()>0){
            int size = queue.size();
            int prevMin = queue.peek().getValue();
            int start = 0;
            int end = 0;
            for(int i =0; i<size; i++){
                TreeNode curr = queue.peek().getKey();
                int currIndex = queue.poll().getValue()-prevMin;
                if(i==0) start = currIndex;
                else if(i==size-1) end = currIndex;
                if(curr.left!=null){
                    queue.offer(new Pair<>(curr.left, currIndex*2+1));
                }
                if(curr.right!=null){
                    queue.offer(new Pair<>(curr.right, currIndex*2+2));
                }
            }
            width = Math.max(width, end-start+1);
        }
        return width;
    }
}