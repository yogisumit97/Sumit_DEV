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
    public ListNode middleNode(ListNode head) {
        ListNode hare = head;
        ListNode tortoise = head;
        while(hare.next!=null && hare.next.next!=null){
            hare= hare.next.next;
            tortoise = tortoise.next;
        }
        if(hare.next==null) return tortoise;
        else return tortoise.next;
    }
}