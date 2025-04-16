class MyQueue {
    Stack<Integer> s1; // main stack
    Stack<Integer> s2; // aux stack
    public MyQueue() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }
    public void push(int x) {
        if(s1.empty()) s1.push(x);
        else{
            while(!s1.empty()){
                int temp = s1.pop();
                s2.push(temp);
            }
            s1.push(x);
            while(!s2.empty()){
                int temp = s2.pop();
                s1.push(temp);
            }
        }
    }
    
    public int pop() {
        if(!s1.empty()) return s1.pop();
        return -1;
    }
    
    public int peek() {
        if(!s1.empty()) return s1.peek();
        return -1;
    }
    
    public boolean empty() {
        if(s1.empty()) return true;
        return false;   
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */