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
    public ListNode oddEvenList(ListNode head) {
        ListNode evenHead = null;
        ListNode evenLast = null;
        ListNode oddHead = null;
        ListNode oddLast = null;
        ListNode curr = head;
        if(curr==null) return curr;
        int count = 1;
        while(curr!=null){
            switch(count%2){
                case 0 :  
                    if(evenHead == null){
                        evenHead = curr;
                        evenLast = curr;
                    }
                    else{
                        evenLast.next = curr;
                        evenLast = evenLast.next;
                    }
                    break;
                case 1 : 
                    if(oddHead == null){
                        oddHead = curr;
                        oddLast = curr;
                    }
                    else{
                        oddLast.next = curr;
                        oddLast = oddLast.next;
                    }
                    break;
            }
            count++;
            curr = curr.next;
        }
        oddLast.next = evenHead;
        if(evenLast!=null) evenLast.next = null;
        return oddHead;
    }
}