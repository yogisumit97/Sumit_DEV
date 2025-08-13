class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>();
        Boolean[][] dp = new Boolean[s.length()+1][s.length()+1];
        for(String str : wordDict) dict.add(str);
        return checkWordInDict(s, 0, 1, dict, dp);
    }
    private boolean checkWordInDict(String s, int start, int end, HashSet<String> dict, Boolean[][] dp){
        if(start>=s.length()) return true;
        if(end>=s.length()){
            return dict.contains(s.substring(start, s.length()));
        }
        if(dp[start][end]!=null) return dp[start][end];
        boolean wordExists = false;
        if(dict.contains(s.substring(start, end))) wordExists|= checkWordInDict(s, end, end+1, dict, dp);
        if(wordExists) return dp[start][end] = true;
        wordExists|= checkWordInDict(s, start, end+1, dict, dp);
        return dp[start][end] = wordExists;
    }
}