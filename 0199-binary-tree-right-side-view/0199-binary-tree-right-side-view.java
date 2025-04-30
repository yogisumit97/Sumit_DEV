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
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int row = 0;
        while(queue.size()>0){
            int size = queue.size();
            while(size>0){
                TreeNode curr = queue.poll();
                rowMap.put(row, curr.val);
                if(curr.left!=null) queue.offer(curr.left);
                if(curr.right!=null) queue.offer(curr.right);
                size--;
            }
            row++;
        }
        //System.out.println(column+" "+root.data);
    }
}


    