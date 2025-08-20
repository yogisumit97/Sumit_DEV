class Solution {
    public int longestStrChain(String[] words) {
        int len = words.length;
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int[][] dp = new int[len+1][len+1];
        for(int i=len-1; i>=0; i--){
            for(int j=len; j>=0; j--){
                // take and skip method
                int take = 0;
                if(j == len || (words[i].length() == words[j].length()+1 && isSubsequence(words, i, j))){
                    take = 1 + dp[i+1][i];
                }
                int skip = dp[i+1][j]; 
                dp[i][j] = Math.max(take, skip);
            }
        }
        return dp[0][len];
    }
    
    private boolean isSubsequence(String[] words, int i, int j){
        int ind1 = 0;
        int ind2 = 0;
        while(ind1 < words[i].length() && ind2 < words[j].length()){
            if(words[i].charAt(ind1) == words[j].charAt(ind2)){
                ind1++;
                ind2++;
            }
            else ind1++;
        }

        if(ind2 == words[j].length()) return true;
        return false;
    } 
}