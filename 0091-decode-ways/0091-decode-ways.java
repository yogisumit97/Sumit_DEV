class Solution {
    public int numDecodings(String s) {
        int[][] dp = new int[s.length()][10];
        return helper(s, 0, 0, dp);
    }
    private int helper(String s, int i, int prev, int[][] dp){
        if(i==s.length()) return 1;
        if(dp[i][prev] !=0) return dp[i][prev];
        int curr = Character.getNumericValue(s.charAt(i));
        int ans = 0;
        if(curr!=0) ans+= helper(s, i+1, curr, dp);
        if(prev!=0 && (prev*10+curr)!=0 && (prev*10+curr)<=26) ans+= helper(s, i+1, 0, dp);
        return dp[i][prev] = ans; 
    }
}