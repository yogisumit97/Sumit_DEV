class Solution {
    public int candy(int[] ratings) { //slope method
        int i = 1;
        int len = ratings.length;
        int sum = 1; // first person 1 candy assigned
        while(i<len){
            if(ratings[i] == ratings[i-1]){
                sum+=1;//flat slope
                i++;
                continue;
            }
            int peak = 1;
            while(i<len && ratings[i]>ratings[i-1]){  // increasing/upward slope
                peak+=1;
                sum+=peak;
                i++;
            }
            int down = 1;
            while(i<len && ratings[i]<ratings[i-1]){  // downward/decreasing slope
                sum+=down;
                down+=1;
                i++;
            }
            if(down>peak) sum+=down-peak;
        }
        return sum;
    }
}