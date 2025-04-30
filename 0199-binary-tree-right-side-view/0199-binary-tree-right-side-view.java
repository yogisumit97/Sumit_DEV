/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.*;
class Solution {
    public class Pair{
        TreeNode curr;
        int row;
        Pair(TreeNode curr, int row){
            this.curr = curr;
            this.row = row;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null) return list;
        SortedMap<Integer, Integer> rowMap = new TreeMap<>();
        traverseTreeLevelWise(root, rowMap);
        //System.out.println(columnMap);
        for(int value : rowMap.values()){
            list.add(value);
        }
        return list;
    }
    private void traverseTreeLevelWise(TreeNode root, SortedMap<Integer,Integer> rowMap){
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root,0));
        while(queue.size()>0){
            int size = queue.size();
            while(size>0){
                Pair pair = queue.poll(); // row is pair.row and node is pair.curr
                int currRow = pair.row;
                TreeNode curr = pair.curr;
                rowMap.put(currRow, pair.curr.val);
                if(curr.left!=null) queue.offer(new Pair(curr.left, currRow+1));
                if(curr.right!=null) queue.offer(new Pair(curr.right, currRow+1));
                size--;
            }
        }
        //System.out.println(column+" "+root.data);
    }
}


    