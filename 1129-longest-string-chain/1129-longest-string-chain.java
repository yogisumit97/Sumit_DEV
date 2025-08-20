class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length()-b.length());
        int len =words.length;
        int[] dp = new int[len];
        int max = 1;
        Arrays.fill(dp, 1);
        for(int i=1; i<len; i++){
            for(int prev = i-1; prev>=0; prev--){
                if(words[prev].length()+1 == words[i].length() && isSubsequence(words, i, prev)){
                    dp[i] = Math.max(dp[i], dp[prev]+1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
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