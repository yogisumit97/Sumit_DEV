/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        //we have to delete node,head is not given,2 possibilities of node as per ques. : head, somewhere mid
        node.val = node.next.val;
        node.next = node.next.next;
    }
}