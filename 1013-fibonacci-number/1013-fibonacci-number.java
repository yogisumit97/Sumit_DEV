class Solution { // o(1) space
    public int fib(int n) {
        if(n==0) return 0;
        int secondPrev = 0;
        int prev = 1;
        for(int i=2; i<n+1; i++){
            int curr = prev + secondPrev;
            secondPrev = prev;
            prev = curr;
        }
        return prev;
    }
}