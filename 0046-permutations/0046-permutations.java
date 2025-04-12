class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        findPermutationsHelper(nums,new ArrayList<Integer>(), ans);
        return ans;
    }
    private void findPermutationsHelper(int[] nums, List<Integer> result, List<List<Integer>> ans){
        if(result.size()==nums.length){
            ans.add(new ArrayList<>(result));
            return;
        }
        for(int i = 0; i<nums.length;i++){
            if(nums[i]==Integer.MIN_VALUE) continue;
            result.add(nums[i]);
            nums[i] = Integer.MIN_VALUE;
            findPermutationsHelper(nums, result, ans);
            nums[i]=result.remove(result.size()-1);
        }
    }
}