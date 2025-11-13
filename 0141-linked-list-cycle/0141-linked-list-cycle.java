public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode hare = head;
        ListNode tortoise = head;
        while(hare!=null && hare.next!=null && tortoise!=null){
            hare = hare.next.next;
            tortoise = tortoise.next;
            if(hare == tortoise) return true;
        }
        return false;
    }
}