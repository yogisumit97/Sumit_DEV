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
    public int findLen(ListNode head){
        ListNode curr = head;
        int len = 0;
        while(curr!=null){
            len++;
            curr = curr.next;
        }
        return len;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        int len = findLen(head);
        int num = k%len;
        if(num==0) return head;
        ListNode curr = head;
        ListNode prev = null;
        while(len!=num){
            prev = curr;
            curr = curr.next;
            num++;
        }
        prev.next = null;
        ListNode newHead = curr;
        while(curr.next!=null) curr= curr.next;
        curr.next = head;
        return newHead;
    }
}