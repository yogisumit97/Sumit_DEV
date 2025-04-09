/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currA = headA;
        ListNode currB = headB;
        while(currA!=null || currB!=null){
            if(currA==currB) return currA;
            if(currA==null){
                currA = headB;
                continue;
            }
            if(currB==null){
                currB = headA;
                continue;
            }
            currA = currA.next;
            currB = currB.next;
        }
        return null;
    }
}