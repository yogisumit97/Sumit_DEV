class Solution {
    public int climbStairs(int n) {
        return climbStairsHelper(n, n);
    }
    private int climbStairsHelper(int n, int curr){
        int pre2 = 1;
        int pre1 = 2;
        if(n==1) return pre2;
        if(n==2) return pre1;
        for(int i=3; i<=n; i++){
            int temp = pre2+pre1;
            pre2 = pre1;
            pre1 = temp;
        }
        return pre1;
    }
}