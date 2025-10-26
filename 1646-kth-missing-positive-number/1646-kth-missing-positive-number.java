class Solution {
    public int findKthPositive(int[] arr, int k) {
        int l = 1;
        int r = 0;
        for(int i : arr) r= Math.max(r, i);
        r+=k;
        while(l<=r){
            int m = (l+r)/2;
            // if m is the answer find how many missing till it.
            int missing = m;
            for(int i : arr){
                if(i>m) break;
                missing--;
            }
            if(missing < k) l = m+1;
            else r = m-1;
        }
        return l;
    }
}