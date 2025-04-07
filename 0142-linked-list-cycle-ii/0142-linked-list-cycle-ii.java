/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        //hare tortoise algo 
        ListNode fast = head;
        ListNode slow = head;
        do{
            if(slow == null || slow.next ==null) return null;
            else if(fast == null || fast.next == null) return null;
            slow = slow.next;
            fast = fast.next.next;
        }while(fast!=slow);
        slow = head;
        while(fast!=slow){
            slow = slow.next;
            fast=fast.next;
        }
        return slow;
    }
}