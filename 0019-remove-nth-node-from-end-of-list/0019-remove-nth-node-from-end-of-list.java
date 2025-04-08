class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr= head;
        ListNode prev = null;
        if(head == null) return head;
        while(curr!=null){
            ListNode temp = curr;
            for(int i =0; i<n;i++){
                if(temp==null) break;
                 temp = temp.next;
            }
            if(temp==null) break;
            prev = curr;
            curr = curr.next;
        }
        if(prev==null && n<=1) return null;
        else if(curr== head && n>1) head = head.next;
        else prev.next = curr.next;
        return head;
    }
}