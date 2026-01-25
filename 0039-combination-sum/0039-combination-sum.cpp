class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>> ans;
        vector<int> temp;
        csHelper(candidates, target, 0, temp, ans);
        return ans;
    }
    void csHelper(vector<int>& candidates, int target, int i, vector<int>& temp, vector<vector<int>>& ans){
        if(target<0) return;
        if(i>=candidates.size()){
            if(target!=0) return;
            vector<int> add = temp;
            ans.push_back(add);
            return;
        }
    
        // take or not take method with backtracking
        temp.push_back(candidates[i]);
        csHelper(candidates, target-candidates[i], i, temp, ans);
        temp.pop_back();
        csHelper(candidates, target, i+1, temp, ans);
    }
};