class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        int i =0;
        int len = nums.length;
        while(i < len){
            int x = i+1; // keeping i and k constant
            while(x < len){
                int j = x + 1;
                int k = len-1;
                while(j<k){
                    long sum = (long)nums[i] + nums[j] + nums[k] + nums[x];
                
                    if(sum > target){
                        k = findNextUnique(nums, k , -1, len);
                    }
                    else if(sum < target){
                        j = findNextUnique(nums, j , 1, len);
                    }
                    else{
                        List<Integer> l = new ArrayList<>();
                        l.add(nums[i]); l.add(nums[j]); l.add(nums[k]); l.add(nums[x]);
                        list.add(l);
                        k = findNextUnique(nums, k , -1, len);
                        j = findNextUnique(nums, j , 1, len);
                    }
                }
                x = findNextUnique(nums, x , 1, len);
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
