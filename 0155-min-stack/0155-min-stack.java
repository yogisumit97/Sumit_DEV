class MinStack {
    Stack<List<Integer>> stack; //size of 2 : first keeps element and second keeps min till now
    public MinStack() {
        stack = new Stack<>();
    }
    public void push(int val) {
        List<Integer> list = new ArrayList<>();
        list.add(val);
        if(stack.empty() || stack.peek().get(1)>val) list.add(val);
        else list.add(stack.peek().get(1));   
        stack.push(list);
    }
    public void pop() {
        if(!stack.empty()) stack.pop();   
    }
    
    public int top() {
        if(!stack.empty()) return stack.peek().get(0);
        return -1;
    }
    
    public int getMin() {
        if(stack.empty()) return Integer.MIN_VALUE;
        return stack.peek().get(1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */