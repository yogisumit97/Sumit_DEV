class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        int i =0;
        int len = nums.length;
        while(i < len){
            int j = i+1;
            int k = len-1;
            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum > 0){
                    k = findNextUnique(nums, k , -1, len);
                }
                else if(sum < 0){
                    j = findNextUnique(nums, j , 1, len);
                }
                else{
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[i]); l.add(nums[j]); l.add(nums[k]);
                    list.add(l);
                    k = findNextUnique(nums, k , -1, len);
                    j = findNextUnique(nums, j , 1, len);
                }
            }
            i = findNextUnique(nums, i , 1, len);
        }
        return list;
    }
    private int findNextUnique(int[] nums, int i, int add, int len){
        int temp = nums[i]; 
        while(i<len && i>=0 && temp == nums[i]){
            i = i+add;
        }
        return i;
    }
}