class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        int n = nums.size();
        for(int num : nums){
            if(num<0) num*=-1;
            if(nums[num-1]>0) nums[num-1]*=-1;
        }
        vector<int> vec;
        for(int i=0; i<n; i++){
            if(nums[i]>0) vec.push_back(i+1);
        }
        return vec;
    }
};