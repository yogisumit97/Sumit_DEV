class Solution {
    public double myPow(double x, int n) {
        if(n==0 || x==1) return 1;
        if(x==-1) return n%2==0 ? 1 : -1;
        if(n== Integer.MIN_VALUE) return 0;
        if(n<0) return myPow(1/x, Math.abs(n));
        
        double half = myPow(x,n/2);
        double result = half*half;
        if(n%2==1) result*=x;
        return result;  
    }
}