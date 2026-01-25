class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int maxi = nums[0];
        int maxPosstillprev = nums[0];
        for(int i =1; i<nums.size(); i++){
            maxPosstillprev =  max(nums[i], nums[i]+maxPosstillprev);
            maxi = max(maxi, maxPosstillprev);
        }
        return maxi;
    }
};