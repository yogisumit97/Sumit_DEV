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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        ListNode head = lists[0]; //head of 1st list;
        if(lists.length==1) return head;
        int currentNode = 1;
        ListNode newHead = head;
        while(currentNode<lists.length){
            ListNode curr = lists[currentNode];
            newHead = mergeSortedLists(newHead,curr);
            currentNode++;
        }
        return newHead;
    }
    private ListNode mergeSortedLists(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(head1!=null && head2!=null){
            if(head1.val<head2.val){
                curr.next = head1;
                curr = curr.next;
                head1 = head1.next;
            }
            else{
                curr.next = head2;
                curr = curr.next;
                head2 = head2.next;
            }
        }
        if(head1!=null) curr.next = head1;
        if(head2!=null) curr.next = head2;
        return dummy.next; 
    }
}