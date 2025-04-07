class Solution {
    public String longestPalindrome(String s) {
        int longest = 1;
        int i =1;
        String ans = "";
        if(s.length()==0) return ans;
        else if(s.length()==1) return s;
        while(i<s.length()){ //iterate string
            int left = i; //odd size palindrome check
            int right = i;
            while(s.charAt(left)==s.charAt(right)){
                left--;
                right++;
                if(left==-1 || right==s.length()) break; 
            }
            String palindrome = s.substring(left+1,right);
            if(palindrome.length()>ans.length()) ans = palindrome;
            
            left = i-1; //even size palindrome check
            right = i;
            while(s.charAt(left)==s.charAt(right)){
                left--;
                right++;
                if(left==-1 || right==s.length()) break; 
            }
            palindrome = s.substring(left+1,right);
            if(palindrome.length()>ans.length()) ans = palindrome;
            
            i++;
        }
        return ans;        
    }
}


