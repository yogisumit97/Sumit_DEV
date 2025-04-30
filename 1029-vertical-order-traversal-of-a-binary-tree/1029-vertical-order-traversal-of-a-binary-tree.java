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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        SortedMap<Integer,List<List<Integer>>> columnMap = new TreeMap<>();
        List<List<Integer>> sameColumnNodes = new ArrayList<>();
        if(root==null) return sameColumnNodes;
        traverseTree(0, 0, root, columnMap);
        for(List<List<Integer>> multilist : columnMap.values()){
            Collections.sort(multilist, new Comparator<List<Integer>>() {
                @Override
                public int compare(List<Integer> list1, List<Integer> list2) {
                    int compareFirst = list1.get(0).compareTo(list2.get(0)); // Compare the first elements
                    if (compareFirst != 0)  return compareFirst; // If different, sort by the first element
                    else    return list1.get(1).compareTo(list2.get(1)); // If the same, sort by the second element
                }
            });
            List<Integer> l = new ArrayList<>();
            for(int i =0; i<multilist.size(); i++){
                List<Integer> list = multilist.get(i);
                l.add(list.get(1));
            }
            sameColumnNodes.add(l);
        }
        return sameColumnNodes;
    }
    public void traverseTree(int row, int column, TreeNode root, SortedMap<Integer,List<List<Integer>>> columnMap){
        if(root== null) return;
        if(columnMap.containsKey(column)){
            List<Integer> list = new ArrayList<>();
            list.add(row);
            list.add(root.val);
            columnMap.get(column).add(list);
        } 
        else{
            List<List<Integer>> list = new ArrayList<>();
            List<Integer> l = new ArrayList<>();
            l.add(row);
            l.add(root.val);
            list.add(l);
            columnMap.put(column, list);
        }
        traverseTree(row+1, column-1, root.left, columnMap);
        traverseTree(row+1, column+1, root.right, columnMap);
    }
}