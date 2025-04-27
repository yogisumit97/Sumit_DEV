class Solution {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] temp = new int[len];
        temp[len-1] = 1;
        for(int i =len-2; i>=0; i--){
            if(ratings[i]>ratings[i+1]) temp[i] = temp[i+1]+1;
            else temp[i]=1;
        }
        int maxCandies = Math.max(temp[0],1);   
        int curr=  1;
        int left = 1;
        for(int i =1; i<len; i++){
            if(ratings[i]>ratings[i-1]){
                curr = left+1;
            }
            else curr = 1;
            left = curr;
            maxCandies+= Math.max(temp[i], curr);
        }
        return maxCandies;
    }
}