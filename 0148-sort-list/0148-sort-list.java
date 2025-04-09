/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */ // use merge sort
class Solution {
    public ListNode sortList(ListNode head) {
        if(head ==null || head.next == null) return head;
        return mergeSort(head);
    }
    public ListNode mergeSort(ListNode curr){
        if(curr.next==null) return curr;
        ListNode mid = findMid(curr); // make it's prev.next as null also
        ListNode left = mergeSort(curr);
        ListNode right = mergeSort(mid);
        return merge(left,right);
    }
    public ListNode findMid(ListNode head){
        //tortoise hare algo
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        return slow;
    }
    public ListNode merge(ListNode head1, ListNode head2){
        ListNode newHead = null;
        ListNode curr1 = head1;
        ListNode curr2 = head2;
        ListNode curr = newHead;
        while(curr1!=null && curr2!=null){
            if(newHead==null){
                if(curr1.val<=curr2.val){
                    newHead = curr1;
                    curr1 = curr1.next;
                }
                else{
                    newHead = curr2;
                    curr2 = curr2.next;
                }
                curr = newHead;
            }
            else{
                if(curr1.val<=curr2.val){
                    curr.next = curr1;
                    curr1 = curr1.next;
                }
                else{
                    curr.next = curr2;
                    curr2 = curr2.next;
                }
                curr = curr.next;
            }
        }
        if (curr1 != null) {
            curr.next = curr1;
        } 
        else {
            curr.next = curr2;
        }
        return newHead;
    }
}