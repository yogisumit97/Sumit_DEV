class StockSpanner {
    Stack<Integer> stack;      //monotonic stack;  >> store in strictly increasing order 
    List<Integer> list;
    public StockSpanner() {
        stack = new Stack<Integer>();
        list = new ArrayList<>();
    }
    public int next(int price) {
        int count = list.size();
        while(!stack.empty() && list.get(stack.peek()) <= price) stack.pop();
        int temp = stack.empty()? count+1 : count - stack.peek();
        stack.push(count);
        list.add(price);    
        return temp;        
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */