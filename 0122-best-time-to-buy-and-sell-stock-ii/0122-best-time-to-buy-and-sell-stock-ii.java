class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int prev0 = 0;
        int prev1 = -1*prices[0];
        for(int i = 1; i< len; i++){
            int temp0 = prev0;
            int temp1 = prev1;
            prev0 = Math.max(temp0, temp1 + prices[i]);
            prev1 = Math.max(temp1, temp0-prices[i]);
        }
        return prev0;
    }
}