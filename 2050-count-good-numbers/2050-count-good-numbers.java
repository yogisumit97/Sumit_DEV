class Solution {
    public final int MOD = 1_000_000_007;
    public int countGoodNumbers(long n) {
        // first digit = 5 no. possible
        // second digit = 4 no. possible, like this you can go on
        // so for any num n >> 5*4*5*4 n times results possible.
        long evenDigits = (n+1)/2;
        long oddDigits = n/2;
        long result = (long)(power(5, evenDigits)*power(4, oddDigits))%MOD; 
        return (int)result; 
    }
    private long power(long num, long pow){
        if(pow==0) return 1;
        if(num==1) return 1;
        long half = power(num, pow/2);
        long res = (half*half)%MOD; // to avoid long overflow
        if(pow%2==0) return res;
        else return (num*res)%MOD;
    }
}