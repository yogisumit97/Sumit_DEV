class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1][len2];
        if(text1.charAt(0)==text2.charAt(0)) dp[0][0] = 1;
        for (int j = 1; j < len2; j++) {
            if (text1.charAt(0) == text2.charAt(j)) dp[0][j] = 1;
            else dp[0][j] = dp[0][j-1];
        }
        for (int i = 1; i < len1; i++) {
            if (text1.charAt(i) == text2.charAt(0)) dp[i][0] = 1;
            else dp[i][0] = dp[i-1][0];
        }
        for(int i1 = 1; i1<len1; i1++){
            for(int i2=1; i2<len2; i2++){
                int match = 0;
                int notMatch = 0;
                if(text1.charAt(i1)== text2.charAt(i2)) match = 1 + dp[i1-1][i2-1];
                else notMatch = Math.max(dp[i1-1][i2], dp[i1][i2-1]);
                dp[i1][i2] = Math.max(match, notMatch);
            }
        }
        return dp[len1-1][len2-1];
    }
}