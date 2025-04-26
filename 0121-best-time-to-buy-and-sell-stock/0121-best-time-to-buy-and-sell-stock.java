class Solution {
    public int maxProfit(int[] prices) {
        int minTillnow = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        for(int i : prices){
            minTillnow = Math.min(minTillnow, i);
            maxProfit = Math.max(maxProfit, i-minTillnow);
        }
        return maxProfit;
    }
}