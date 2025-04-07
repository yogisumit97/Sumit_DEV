/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode upcoming = head;
        ListNode prev = null;
        if(head==null) return head;
        while(curr!=null){
            upcoming = curr.next;
            curr.next = prev;
            prev = curr;
            curr = upcoming;
        }
        return prev;
    }
}