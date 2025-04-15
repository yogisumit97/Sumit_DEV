class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == divisor) return 1;
        boolean sign =true; // true for positive and false for negative
        if((dividend>0 && divisor<0)||(dividend<0 && divisor>0)) sign =false;
        long n = Math.abs((long)dividend);
        long d = Math.abs((long)divisor);
        long res = 0;
        while(n>=d){
            int count = -1;
            while(n>=(d<<(count+1))) count++;
            res+= ((long)1)<<count;
            n = n-(d<<count);
        }
        if(res>Integer.MAX_VALUE || res < Integer.MIN_VALUE ){
            if(sign) res = Integer.MAX_VALUE;
            else res = Integer.MIN_VALUE;
        }
        return sign? (int)res : (int)(-res);
    }
}