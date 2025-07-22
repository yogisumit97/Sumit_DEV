class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length()][p.length()];
        return helper(s, p, s.length()-1, p.length()-1, dp);
    }
    private boolean helper(String s, String p, int i1, int i2, Boolean[][] dp){
        if(i1==-1 && i2<=-1) return true;
        if(i1==-1){
            while(i2>=0 && p.charAt(i2)=='*') i2=i2-2;
            if(i2<=-1) return true;
            return false;
        }
        if(i2<=-1) return false;
        if(dp[i1][i2]!=null) return dp[i1][i2];
        if(s.charAt(i1)== p.charAt(i2) || p.charAt(i2)=='.'){
            return dp[i1][i2] = helper(s,p,i1-1, i2-1, dp);
        }
        else if(p.charAt(i2)=='*'){
            boolean check = false; // check if prev matches  
            if(i1>=0 && i2-1>= 0 && (s.charAt(i1) == p.charAt(i2-1)|| p.charAt(i2-1)=='.')) check = helper(s, p, i1-1, i2, dp);
            return dp[i1][i2] = helper(s, p, i1, i2-2, dp)| check;
        }
        else return dp[i1][i2] = false;
    }
}