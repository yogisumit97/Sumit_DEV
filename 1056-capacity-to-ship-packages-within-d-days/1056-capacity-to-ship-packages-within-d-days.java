class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = 0;
        int r = 0;
        for(int i : weights){
            l = Math.max(l, i);
            r+=i;
        }
        while(l<=r){
            int m =(l+r)/2; // this much weight to check for bs.
            int numDays = 0;
            int sum = 0;
            for(int i : weights){
                sum+=i;
                if(sum >= m){
                    numDays++;
                    sum = sum==m? 0 : i;
                }
            }
            if(sum!=0) numDays++;
            if(numDays> days) l = m+1;
            else r = m-1;
        }
        return l;
    }
}