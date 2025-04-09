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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k==0) return head;
        ListNode curr = head;
        int len = 1;
        while(curr.next!=null){
            len++;
            curr = curr.next;
        }
        int num = k%len;
        if(num==0) return head;
        curr.next = head;
        curr = head;
        ListNode prev = null;
        while(len!=num){
            prev = curr;
            curr = curr.next;
            num++;
        }
        prev.next = null;
        return curr;
    }
}