class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        findPermutationsHelper(0, nums, ans);
        return ans;
    }
    private void findPermutationsHelper(int index, int[] nums, List<List<Integer>> ans){
        if(index==nums.length){
            List<Integer> result = new ArrayList<>();
            for(int i : nums) result.add(i);
            ans.add(new ArrayList<>(result));
            return;
        }
        for(int i = index; i<nums.length;i++){
            swap(nums,i,index);
            findPermutationsHelper(index+1, nums, ans);
            swap(nums,i,index); 
        }
        return;
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}