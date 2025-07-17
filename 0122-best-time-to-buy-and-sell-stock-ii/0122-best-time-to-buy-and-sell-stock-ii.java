class Solution {
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int profit = 0;
        for(int curr : prices){
            if(curr <= buy) buy = curr;
            else{
                profit+= curr- buy;
                buy = curr;
            }
        }
        return profit;
    }
}