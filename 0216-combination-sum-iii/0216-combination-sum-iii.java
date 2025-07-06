class Solution {
    public List<List<Integer>> combinationSum3(int k, int tar) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        List<List<Integer>> list = new ArrayList<>();
        cS3Helper(arr, 0, tar, new ArrayList<Integer>(), list, k);
        return list;  
    }
    private void cS3Helper(int[] arr, int i, int tar,List<Integer> res,List<List<Integer>> list, int k){
        if(i>=arr.length || res.size()==k){
            if(tar==0 && res.size()==k) list.add(new ArrayList<>(res));
            return;
        }
        res.add(arr[i]);
        cS3Helper(arr, i+1, tar-arr[i], res, list, k);
        res.remove(res.size()-1);
        cS3Helper(arr, i+1, tar, res, list, k);
    }
}