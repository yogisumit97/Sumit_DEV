class Solution {
    int[] dp = new int[46];
    public int climbStairs(int n) {
        for(int i =1; i<=n; i++){
            if(i==1 || i==2) dp[i]=i;
            else dp[i]= dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}

/*
stairs 1 2 3 4 5 6
output 1 2 3 5 8 13  

op(n)= op(n-1)+op(n-2); // kind of fibonacci;
as tle we need memoization
*/
