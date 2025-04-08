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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode curr = null;
        int carry = 0;
        while(l1!=null && l2!=null){
            int num = carry+l1.val+l2.val;
            carry = num/10;
            num = num%10;
            ListNode temp = new ListNode(num);
            if(head==null){
                head = temp;
                curr = head;
            }
            else{
                curr.next = temp;
                curr = curr.next;
            }
            l1= l1.next;
            l2 = l2.next;
        }   
        while(l1!=null){
            int num = carry+l1.val;
            carry = num/10;
            num = num%10;
            ListNode temp = new ListNode(num);
            curr.next = temp;
            curr = curr.next;
            l1 = l1.next;
        } 
        while(l2!=null){
            int num = carry+l2.val;
            carry = num/10;
            num = num%10;
            ListNode temp = new ListNode(num);
            curr.next = temp;
            curr = curr.next;
            l2 = l2.next;
        }
        if(carry!=0){
            curr.next = new ListNode(carry);
        }
        return head;
    }
}