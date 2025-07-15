class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1][len2];
        return mdHelper(word1, word2, len1-1, len2-1, dp);
    }
    private int mdHelper(String s1, String s2, int i1, int i2, int[][] dp){
        if(i2<0) return i1+1;
        if(i1<0) return i2+1;
        if(dp[i1][i2]!=0) return dp[i1][i2];
        // last character matching 
        int match = 0;
        if(s1.charAt(i1)==s2.charAt(i2)) return mdHelper(s1, s2, i1-1, i2-1, dp);
        else{ // nonMatching cases
            int insert = 1 + mdHelper(s1, s2, i1, i2-1, dp);
            int delete = 1 + mdHelper(s1, s2, i1-1, i2, dp);
            int replace = 1 + mdHelper(s1, s2, i1-1, i2-1, dp);
            return dp[i1][i2] = Math.min(insert, Math.min(delete, replace));
        }
    }
}