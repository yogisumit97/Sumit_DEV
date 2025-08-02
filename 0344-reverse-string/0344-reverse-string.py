class Solution:
    def reverseString(self, s: List[str]) -> None:
        return self.reverse(s, 1)

    def reverse(self, s : List[str], num : int) -> None:
        if(num>len(s)):
             return
        ch = s[num-1]
        self.reverse(s,num+1)
        s[len(s)-num] = ch