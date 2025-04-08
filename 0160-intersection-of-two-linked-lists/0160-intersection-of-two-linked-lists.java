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
        HashSet<ListNode> hset = new HashSet<>();
        ListNode curr1 =  headA;
        ListNode curr2 = headB;
        
        while(curr1!=null && curr2!=null){
            if(hset.contains(curr1)) return curr1;
            hset.add(curr1);
            if(hset.contains(curr2)) return curr2;
            hset.add(curr2);
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        while(curr1!=null){
            if(hset.contains(curr1)) return curr1;
            curr1 = curr1.next;
        }
        while(curr2!=null){
            if(hset.contains(curr2)) return curr2;
            curr2 = curr2.next;
        }
        return null;
    }
}