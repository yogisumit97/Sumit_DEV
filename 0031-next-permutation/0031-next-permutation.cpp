class Solution {
public:
    void swap(vector<int>& nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;  
    }
    void nextPermutation(vector<int>& nums) {
        int len = nums.size();
        int ind = -1;
        for(int i=len-2; i>=0; i--){
            if(nums[i] >= nums[i+1]) continue;
            else{
                ind = i;
                break;
            }
        }
        if(ind==-1){
            reverse(nums.begin(), nums.end());
            return;
        }
        int j = len-1;
        int i = ind;
        while(j>i){
            if(nums[j] > nums[i]) break;
            j--;
        }        
        swap(nums, i, j);
        //swap remaining.
        j = len-1;
        i++;
        while(i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }
};


// 4 1 3 2  >>  4 3 1 2