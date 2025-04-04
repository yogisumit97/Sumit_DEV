class Solution {
    public String removeOuterParentheses(String s) {
        int cnt = 0;
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<s.length();i++){
            char c = s.charAt(i);
            if(c=='(') cnt++;
            else if(c==')') cnt--;
            if(c=='(' && cnt-1!=0) ans.append(c); //so first ( is not added to ans
            else if(c==')' && cnt!=0) ans.append(c); // so last ) is not added to ans
        }
        return ans.toString();
    }
}