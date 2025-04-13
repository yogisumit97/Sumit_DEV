class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n==1) return true;
        if((n&1)!=0 || n<=0) return false; //odd except 1
        return isPowerOfTwo(n>>1); // check n/2;
    }
}

