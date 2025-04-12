class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        generateCombinationsHelper(0,candidates,target,0, new ArrayList<Integer>(), ans);
        return ans;
    }
    public void generateCombinationsHelper(int index,int[] arr, int target,int sum, List<Integer> result, List<List<Integer>> ans){
        if(index>=arr.length || sum>=target){
            if(sum==target) ans.add(new ArrayList<Integer>(result));    
            return;
        }
        result.add(arr[index]);//take element
        generateCombinationsHelper(index,arr,target,sum+arr[index], result, ans);
        result.remove(result.size()-1);//not take element
        generateCombinationsHelper(index+1,arr,target,sum, result, ans);
        return;
    }
}