class Solution {
    public int[] temp = new int[31];
    public int fib(int n) {
        if(temp[n]!=0) return temp[n];
        if(n==0 || n==1) return n;
        else{
            temp[n] = fib(n-1) + fib(n-2);
            return temp[n];
        }
    }
}