class Solution {
    public double myPow(double x, int n) {
        if(n==1) return x;
        if(n==0 || x==1) return 1;
        if(x==-1){
            int temp=1;
            if(n%2!=0) temp=-1;
            return temp;
        }
        if(n==Integer.MIN_VALUE) return 0;
        int sign = 1;// 1 for positive and -1 for negative.
        if(n<0){
            sign = -1;
            n*=sign; // make n positive
        }
        double result = 0;
        if(n%2==0) result = myPow(x*x, n/2);
        else result=  x*myPow(x*x,n/2);
        if(sign<0) return 1/result;
        else return result; 
    }
}