class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int maxPrev = 1;
        int maxi = 0;
        if(nums.size()==1) return nums[0];
        for(int i =0; i<nums.size(); i++){
            maxPrev = maxPrev*nums[i];
            maxi = max(maxi, maxPrev);
            if(maxPrev==0) maxPrev = 1;
        }
        maxPrev = 1;
        for(int i =nums.size()-1; i>=0; i--){
            maxPrev = maxPrev*nums[i];
            maxi = max(maxi, maxPrev);
            if(maxPrev==0) maxPrev = 1;
        }
        return maxi;
    }
};