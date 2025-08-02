class Solution {
public:
    bool isPalindrome(int x) {
        if(x<0) return false;
        int temp = reverse(x);
        if(temp==x) return true;
        return false;
    }
    int reverse(int x) {
        int sign = x>=0 ? 1 : -1;
        long temp = ((long)x)*sign;
        long res = 0;
        while(temp>0){
            res =  res*10+temp%10;
            temp/=10;
        }
        if(res<INT_MIN || res>INT_MAX) return 0;
        return sign*(int)res;
    }
};