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
        ListNode head = new ListNode();
        ListNode curr = head;
        int mask = 0;
        while(!(l1==null && l2==null)){
            if(l1==null){
                curr.next = l2;
                curr = curr.next;
                curr.val = curr.val + mask;
                mask = curr.val/10;
                curr.val = curr.val%10;
                l2 = l2.next;
                if(l2==null && mask!=0){
                    ListNode temp = new ListNode(mask,null);
                    curr.next =temp;
                }
                continue;
            } else if(l2==null){
                curr.next = l1;
                curr = curr.next;
                curr.val = curr.val + mask;
                mask = curr.val/10;
                curr.val = curr.val%10;
                l1 = l1.next;
                if(l1==null && mask!=0){
                    ListNode temp = new ListNode(mask,null);
                    curr.next =temp;
                }
                continue;
            }
            else{
                ListNode temp = new ListNode(0,null);
                int num = l1.val + l2.val+ mask;
                l1 = l1.next;
                l2 = l2.next;
                mask = num/10;
                num = num%10;
                temp.val = num;
                if(head==null){
                    head = temp;
                    curr=temp;
                    continue;
                }
                
                curr.next = temp;
                curr = curr.next;
                if(l1==null && l2==null && mask!=0){
                    ListNode temp2 = new ListNode(mask,null);
                    curr.next = temp2;
                }
            }
        }
        return head.next;
    }
}