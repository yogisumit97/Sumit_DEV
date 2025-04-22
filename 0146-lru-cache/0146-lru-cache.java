class Node {
    int key;
    int value;
    Node prev;
    Node next;
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}
class Dll {
    Node head;
    Node tail;
    public Dll() {
        head = null;
        tail = null;
    }
    public void addFirst(Node curr){
        if(head==null && tail==null){
            head = curr;
            tail = curr;
        }
        else{
            curr.next = head;
            head.prev = curr;
            head = curr;
        }
    }
    public void delete(Node curr){
        if(curr==head && curr==tail){
            head=tail=null;
        }
        else if(curr==head){
            head = head.next;
            head.prev = null;
        }
        else if(curr==tail){
            tail = tail.prev;
            tail.next = null;
        }
        else{
            Node temp = curr.next;
            temp.prev = curr.prev;
            curr.prev.next = temp;
        }
    }
    public int deleteLast(){
        int key = tail.key;
        tail = tail.prev;
        if(tail!=null) tail.next = null;
        else head = null;
        return key;
    }
}
class LRUCache {
    HashMap<Integer,Node> hm;
    Dll dll;
    int rem_size;
    public LRUCache(int capacity) {
        dll = new Dll();
        hm = new HashMap<>();
        rem_size = capacity;
    }
    public int get(int key) {
        if(hm.containsKey(key)){
            Node curr = hm.get(key);
            dll.delete(curr);
            dll.addFirst(curr);
            return curr.value;
        }
        return -1;
    }
    public void put(int key, int value) {
        //System.out.println(hm);
        if(hm.containsKey(key)){
            Node curr = hm.get(key);
            curr.value = value;
            dll.delete(curr);
            dll.addFirst(curr);
            return;
        }
        Node curr = new Node(key,value);
        if(rem_size ==0){
            int currKeyToDelete = dll.deleteLast();
            hm.remove(currKeyToDelete);
        }
        else{
            rem_size--;
        }
        dll.addFirst(curr);
        hm.put(key, curr);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */