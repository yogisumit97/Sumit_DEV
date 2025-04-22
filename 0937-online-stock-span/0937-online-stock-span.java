class StockSpanner {
    Stack<List<Integer>> stack;//monotonic stack; store in decreaing order price + no. of day on which it happened
    public StockSpanner() {
        stack = new Stack<>();
    }
    public int next(int price) {
        int count =stack.empty()? 0 : stack.peek().get(1)+1;
        while(!stack.empty() && stack.peek().get(0)<= price) stack.pop();
        int temp = stack.empty()? count+1 : count - stack.peek().get(1);
        List<Integer> list = new ArrayList<>();
        list.add(price);
        list.add(count);
        stack.push(list);
        return temp;        
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */