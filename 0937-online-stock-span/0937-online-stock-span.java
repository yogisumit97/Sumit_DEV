class StockSpanner {
    Stack<Integer> stack;      //monotonic stack;  >> store in strictly increasing order 
    List<Integer> list;
    int count;
    public StockSpanner() {
        stack = new Stack<Integer>();
        list = new ArrayList<>();
        count = 0;
    }
    public int next(int price) {
        while(!stack.empty() && list.get(stack.peek()) <= price) stack.pop();
        int temp = stack.empty()? count+1 : count - stack.peek();
        stack.push(count);
        count++;
        list.add(price);    
        return temp;        
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */