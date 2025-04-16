class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;
    public MyStack() {
        q1 = new LinkedList<>(); // main queue
        q2 = new LinkedList<>(); // aux queue
    }
    public void push(int x) {
        q1.offer(x);        
    }
    
    public int pop() {
        int temp = 0;
        while(!q1.isEmpty()){
            temp = q1.poll();
            if(q1.isEmpty()) break;
            q2.offer(temp);
        }
        while(!q2.isEmpty()){
            int temp2 = q2.poll();
            q1.offer(temp2);
        }
        return temp;
    }
    public int top() {
        int temp = 0;
        while(!q1.isEmpty()){
            temp = q1.poll();
            q2.offer(temp);
        }
        while(!q2.isEmpty()){
            int temp2 = q2.poll();
            q1.offer(temp2);
        }
        return temp;
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */