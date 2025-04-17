class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>(); //keeps track of next max
        for(int i =nums.length-1; i>=0; i--){
            while(!stack.empty() && stack.peek()<nums[i]){
                stack.pop();
            }
            stack.push(nums[i]);    
        }
        int count = nums.length-1;
        while(count>=0){
            int res = -1;
            while(!stack.empty() && stack.peek()<=nums[count]){
                stack.pop();
            }
            if(!stack.empty()) res = stack.peek();
            result[count]= res;
            stack.push(nums[count]);
            count--;
        }
        return result;
    }
}