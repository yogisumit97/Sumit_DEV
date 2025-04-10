class Solution {
    static final int MOD = 1_000_000_007;
    public int countGoodNumbers(long n) {
        long even = (n+1)/2;
        long odd = n/2;

        long resEven = power(5, even);
        long resOdd = power(4, odd);

        return (int)((resEven*resOdd)%MOD);
    }
    public long power(int base, long pow){ //divide and conquer 
        if(pow==0) return 1;
        long half = power(base, pow/2);
        long result = (half*half)%MOD;
        if(pow%2==1) result = (result*base)%MOD;
        return result;
    }
}
