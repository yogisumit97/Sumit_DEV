class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        set<int> hset;
        for(int num : nums){
            if(hset.contains(num)) return true;
            hset.insert(num);
        }
        return false;
    }
};