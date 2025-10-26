class Solution {
    public int minDays(int[] bloomDay, int M, int k) {
        if(1L*M*k > bloomDay.length) return -1;
        int l = Integer.MAX_VALUE;
        int r = 0;
        for(int i : bloomDay){
            l = Math.min(i, l);
            r = Math.max(i, r);
        }
        while(l<=r){
            int m = (l+r)/2; // m shows no. of days.
            int numBuq = 0;
            int conseq = 0;
            for(int i : bloomDay){
                if(i<=m){
                    conseq+= 1;
                    if(conseq==k){
                        conseq = 0;
                        numBuq+= 1;
                    }
                }
                else conseq = 0;
            }
            if(numBuq < M){
                l = m+1;
            }
            else r = m-1;
        }
        return l;
    }
}