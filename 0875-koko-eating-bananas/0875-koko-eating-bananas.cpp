class Solution {
public:
    int minEatingSpeed(vector<int>& piles, int h) {
        int minSpeed = 1;
        int maxSpeed = 0;
    for(int i : piles) maxSpeed = max(i, maxSpeed);
        int neededSpeed = 0;
        while(minSpeed<=maxSpeed){
            int currSpeed = (minSpeed+maxSpeed)/2;
            long int time = 0;
            for(int pile : piles){
                double f = pile*1.0/currSpeed;
                int i = (int)ceil(f);
                time+=i;
            }
            if(time > h){
                minSpeed = currSpeed+1;
            }
            else{
                maxSpeed = currSpeed-1;
            }
        }
        return minSpeed;
    }
};