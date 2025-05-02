// approach will be to make a new hashmap where immediate parent will be stored for every child
// while doing DFS go one layer on parents side too. when distance is reached return queue.
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,TreeNode> parent = new HashMap<>(); //child-parent map
        Set<TreeNode> visited = new HashSet<>();
        traverseTree(root, parent); // apply BFS and update parent map.
        int distance = 0;
        List<Integer> list = new ArrayList<>();
        distanceKHelper(target, parent, k, visited, list);
        return list;
    }
    private void distanceKHelper(TreeNode target, HashMap<TreeNode,TreeNode> parent, int k, Set<TreeNode> visited, List<Integer> list){
        if(target==null) return;
        visited.add(target);
        if(k==0){
            list.add(target.val);
            return;
        }
        if(!visited.contains(target.left)) distanceKHelper(target.left, parent, k-1, visited, list);
        if(!visited.contains(target.right)) distanceKHelper(target.right, parent, k-1, visited, list);
        if(!visited.contains(parent.get(target)))distanceKHelper(parent.get(target), parent, k-1, visited, list);
    }
    private void traverseTree(TreeNode root, HashMap<TreeNode,TreeNode> parent){
        if(root==null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        if(queue.size()==0){
            queue.offer(root);
            parent.put(root, null);
        }
        while(queue.size()!=0){
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode curr = queue.poll();
                if(curr.left!=null){
                    queue.offer(curr.left);
                    parent.put(curr.left, curr);
                }
                if(curr.right!=null){
                    queue.offer(curr.right);
                    parent.put(curr.right, curr);
                }
            }
        }
    }
}