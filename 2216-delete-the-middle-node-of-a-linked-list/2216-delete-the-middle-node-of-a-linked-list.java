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
    public ListNode deleteMiddle(ListNode head) {
        ListNode hare = head;
        ListNode tortoise = head;
        ListNode tortoise_prev = head;
        if(head.next==null) return null;
        while(hare.next!=null && hare.next.next!=null){
            hare = hare.next.next;
            tortoise_prev = tortoise;
            tortoise = tortoise.next;
        }
        if(hare.next!=null && hare.next.next==null){
            tortoise_prev = tortoise;
            tortoise=tortoise.next;
        }
        //now remove tortoise
        tortoise_prev.next = tortoise.next;
        tortoise.next = null;
        return head;
    }
}