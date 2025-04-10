class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head ==null || head.next==null || k<=1) return head;
        ListNode curr = head;
        ListNode overallHead = null;
        ListNode currHead = head;
        ListNode nextNode = null;
        ListNode prevLast = null;
        int num = 1;
        while(curr!=null){
            if(num==k){
                num = 1;
                nextNode = curr.next;
                curr.next = null;
                ListNode temp =currHead;
                currHead = reverse(currHead, nextNode);
                if(overallHead==null) overallHead = currHead;
                if(prevLast!=null){
                    prevLast.next = currHead;
                }
                prevLast = temp;
                curr = nextNode;
                currHead = nextNode;
                continue;
            }
            num++;
            curr= curr.next;
        }
        return overallHead;
    }
    public ListNode reverse(ListNode head, ListNode nextNode) {
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        head.next = nextNode;
        return prev;
    }
}