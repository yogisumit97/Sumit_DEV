class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        Integer[][] dp = new Integer[text1.length()][text2.length()];
        return lcsHelper(text1, text2, text1.length()-1, text2.length()-1, dp);
    }
    private int lcsHelper(String s1, String s2, int i1, int i2, Integer[][] dp){
        if(i1<0 || i2<0) return 0;
        if(dp[i1][i2]!=null) return dp[i1][i2];
        int match = 0;
        int notMatch = 0;
        if(s1.charAt(i1)== s2.charAt(i2)) match = 1 + lcsHelper(s1, s2, i1-1, i2-1, dp);
        else notMatch = Math.max(lcsHelper(s1, s2, i1-1, i2, dp), lcsHelper(s1, s2, i1, i2-1, dp));
        return dp[i1][i2] = Math.max(match, notMatch);
    }
}