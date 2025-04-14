class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> hm = new HashMap<>();
        Node curr = head;
        Node prev = null;
        Node newHead = null;
        while(curr!=null){
            Node temp = new Node(curr.val);
            if(newHead ==null) newHead=temp;
            if(prev!=null){
                prev.next = temp;
                prev =temp;
            }
            else prev = temp;
            hm.put(curr,temp);
            curr= curr.next;
        }
        curr = head;
        Node curr1 = newHead;
        while(curr!=null){
            curr1.random = hm.get(curr.random);
            curr = curr.next;
            curr1 = curr1.next;
        }
        return newHead;
    }
}