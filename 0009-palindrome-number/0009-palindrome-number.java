class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int temp = reverse(x);
        if(x==temp) return true;
        return false;
    }
    public int reverse(int x) {
        long res = 0;
        int sign = x>=0 ? 1 : -1;
        int temp = x*sign;
        
        while(temp>0){
            res = res*10+temp%10;
            temp/=10;
        }
        if(res<Integer.MIN_VALUE || res>Integer.MAX_VALUE) return 0;
        else return (int) sign*(int)res;
    }
}