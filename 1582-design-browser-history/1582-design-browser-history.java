class BrowserHistory {
    Stack<String> urlList1;
    Stack<String> urlList2;
    public BrowserHistory(String homepage) {
        urlList1 = new Stack<>();
        urlList1.push(homepage);
        urlList2 = new Stack<>();
    }
    public void visit(String url) {
        urlList1.push(url);
        urlList2.clear(); // clearing forward History    
    }   
    public String back(int steps) {
        while(steps!=0 && !urlList1.empty()){
            String pop =urlList1.pop();
            if(!urlList1.empty()) urlList2.push(pop);
            else{
                urlList1.push(pop);
                break;
            }
            steps--;
        }
        return urlList1.peek();    
    }
    public String forward(int steps) {
        while(steps!=0 && !urlList2.empty()){
            String pop =urlList2.pop();
            urlList1.push(pop);
            steps--;
        }
        return urlList1.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */