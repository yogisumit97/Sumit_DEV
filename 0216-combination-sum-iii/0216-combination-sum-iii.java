class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] arr = {1,2,3,4,5,6,7,8,9}; //n =target, k = no. of elements from arr so that sum reaches target
        int min = 0;
        int max = 0;
        for(int i =0;i<k;i++){
            min+=arr[i];
            max+=arr[arr.length-i-1];
        }
        List<List<Integer>> ans = new ArrayList<>();
        if(min>n || max<n) return ans;
        findCombinationsHelper(0,arr,0,n,k,new ArrayList<Integer>(),ans);
        return ans;
    }
    private void findCombinationsHelper(int index, int[] arr,int sum,int target,int maxElements, List<Integer> result,List<List<Integer>> ans){
        if(index>=arr.length || sum>=target || result.size()>=maxElements){
            if(sum==target && result.size()==maxElements) ans.add(new ArrayList<>(result));
            return;
        }
        //take or not take method
        result.add(arr[index]);
        findCombinationsHelper(index+1,arr,sum+arr[index],target,maxElements,result,ans);
        result.remove(result.size()-1);
        findCombinationsHelper(index+1,arr,sum,target,maxElements,result,ans);
    }
}