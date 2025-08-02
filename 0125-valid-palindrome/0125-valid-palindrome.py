class Solution:
    def isPalindrome(self, s: str) -> bool:
        s = s.lower()
        return self.check(s, 0, len(s)-1)

    def check(self, s: str, start : int, end : int) -> bool:
        if(start>=end):
            return True
        if(not s[start].isalnum()):
            return self.check(s, start+1, end)
        if(not s[end].isalnum()):
            return self.check(s, start, end-1)
        if(s[start] is not s[end]):
            return False
        return self.check(s, start+1, end-1)
