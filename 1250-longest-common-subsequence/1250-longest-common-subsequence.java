class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        Integer[][] dp = new Integer[len1][len2];
        return lcsHelper(text1, text2, len1-1, len2-1, dp);
    }
    private int lcsHelper(String s1, String s2, int i1, int i2, Integer[][] dp){
        if(i1<0 || i2<0) return 0;
        if(dp[i1][i2] !=null) return dp[i1][i2];
        if(s1.charAt(i1) == s2.charAt(i2)) return dp[i1][i2] = 1 + lcsHelper(s1, s2, i1-1, i2-1, dp);
        else return dp[i1][i2] = Math.max(lcsHelper(s1, s2, i1, i2-1, dp),lcsHelper(s1, s2, i1-1, i2, dp));
    }
}