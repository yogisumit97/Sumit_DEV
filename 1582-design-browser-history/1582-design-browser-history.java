class BrowserHistory {
    List<String> list;
    int curr;
    public BrowserHistory(String homepage) {
        list = new ArrayList<>();
        list.add(homepage);
        curr = 0; // for homepage
    }
    public void visit(String url) {
        int count = list.size()-1;
        while(count>curr){
            list.remove(count); 
            count--;
        }
        list.add(curr+1,url);
        curr = curr+1;
    }   
    public String back(int steps) {
        curr = Math.max(0, curr-steps);
        return list.get(curr);    
    }
    public String forward(int steps) {
        curr = Math.min(list.size()-1, curr+steps);
        return list.get(curr);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */