class Solution {
    public double myPow(double x, int n) {
        if(x==0) return 0;
        if(n==0) return 1;
        if(n==Integer.MIN_VALUE){
            return 1/myPow(x*x, (n/2)*-1);
        }
        if(n<0) return 1/myPow(x, -1*n);
        double result = x*x;
        if(n%2==0) return myPow(result, n/2);
        else return x*myPow(result, n/2);
    }
}