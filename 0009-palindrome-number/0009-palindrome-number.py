class Solution:
    def reverse(self, x: int) -> int:
        sign = -1
        if x>=0 :
            sign = 1
        temp = x*sign
        res = 0
        while(temp>0):
            res = res*10+temp%10
            temp//=10
        if res < -2**31 or res > 2**31 - 1:
            return 0
        return res*sign
    
    def isPalindrome(self, x: int) -> bool:
        if x<0:
            return False
        temp = self.reverse(x)
        if temp==x :
            return True
        return False