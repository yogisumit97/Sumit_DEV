class Solution {
    public void deleteNode(ListNode node) {
        ListNode nex = node.next;
        ListNode curr = node;
        while(nex!=null){
            curr.val = nex.val;
            if(nex.next==null){
                curr.next= null;
                break;
            }
            curr = nex;
            nex = nex.next;
        }
    }
}