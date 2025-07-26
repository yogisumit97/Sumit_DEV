class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        int[][] dp = new int[len+1][10];
        for(int prev =0; prev<10; prev++) dp[len][prev] = 1;
        for(int i=s.length()-1; i>=0; i--){
            for(int prev=0; prev<10; prev++){
                int curr = Character.getNumericValue(s.charAt(i));
                int ans = 0;
                if(curr!=0) ans+= dp[i+1][curr];
                if(prev!=0 && (prev*10+curr)!=0 && (prev*10+curr)<=26) ans+= dp[i+1][0];
                dp[i][prev] = ans;
            }
        }
        return dp[0][0];
    }
}