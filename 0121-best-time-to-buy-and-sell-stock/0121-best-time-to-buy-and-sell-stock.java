class Solution {
    public int maxProfit(int[] prices) {
        int minTillnow = prices[0];
        int maxProfit = 0;
        for(int i=1; i< prices.length; i++){
            if(prices[i] < minTillnow) minTillnow = prices[i];
            else maxProfit = Math.max(maxProfit, prices[i]-minTillnow);
        }
        return maxProfit;
    }
}