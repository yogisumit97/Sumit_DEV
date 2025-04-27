class Solution {
    private class Rating {
        int rating;
        int index;
        Rating(int rating , int index){
            this.rating = rating;
            this.index = index;
        }
    }
    public int candy(int[] ratings) {
        int len = ratings.length;
        if(len==1) return 1;
        Rating[] rating = new Rating[len];
        for(int i =0; i<len; i++){
            rating[i] = new Rating(ratings[i], i);
        }
        Arrays.sort(rating, new Comparator<Rating>(){
            @Override
            public int compare(Rating a, Rating b){
                return Integer.compare(a.rating, b.rating);
            }
        });
        int[] candies = new int[len]; // initially 0 candies;
        int maxCandies = 0;
        for(Rating r : rating){ //r.rating is present rating which is in ascending order
            int i = r.index;
            if(i!=0 && i!=len-1){
                if(ratings[i]==ratings[i-1]){
                    if(ratings[i]<=ratings[i+1]) candies[i] = 1;
                    else candies[i] = candies[i+1]+1;
                }
                else candies[i] = Math.max(candies[i-1], candies[i+1])+1;
            }
            else if(i==0) candies[i] = candies[i+1]+1;
            else{
                if(ratings[i]==ratings[i-1]) candies[i]=1;
                else candies[i] = candies[i-1]+1;
            }
            maxCandies+=candies[i];
        }
        return maxCandies;
    }
}

