class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Integer[][] dp = new Integer[words.length+1][words.length+1];
        return helper(0, words, words.length, dp);
    }
    private int helper(int i, String[] words, int prevIdx, Integer[][] dp){
        if(i>= words.length){
            return 0;
        }
        if(dp[i][prevIdx]!=null) return dp[i][prevIdx];
        // take and skip method
        int take = 0;
        if(prevIdx ==words.length || (words[i].length() == words[prevIdx].length()+1 && isSubsequence(words, i, prevIdx))){
            take = 1 + helper(i+1, words, i, dp);
        }
        int skip = helper(i+1, words, prevIdx, dp);
        return dp[i][prevIdx] = Math.max(take, skip);
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