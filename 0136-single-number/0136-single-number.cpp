class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int _xor = 0;
        for(int num : nums) _xor^=num;
        return _xor;
    }
};