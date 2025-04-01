import java.util.HashMap;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length;i++){
            if(map.containsKey(nums[i])) return new int[]{map.get(nums[i]),i};
            else    map.put(target-nums[i],i);
        }
        return new int[] {-1,-1};
    }
    public static void main(String[] args) {
    Solution solution = new Solution();
    int[] nums = {2, 7, 11, 15};
    int target = 9;
    int[] result = solution.twoSum(nums, target);
    System.out.println("Result: [" + result[0] + ", " + result[1] + "]");
}
}