class Solution {
    public long subArrayRanges(int[] nums) {
        int len = nums.length;
        int[] pseeIndex = findPseeHelper(nums, len);
        int[] nseIndex = findNseHelper(nums, len);
        int[] pgeeIndex = findPgeeHelper(nums,len);
        int[] ngeIndex = findNgeHelper(nums, len);
        long sum = 0;
        for(int i =0; i<len ; i++){
            sum+= (1L*nums[i]*(i-pgeeIndex[i])*(ngeIndex[i]-i));
            sum-= (1L*nums[i]*(i-pseeIndex[i])*(nseIndex[i]-i));
        }
        return sum;
    }
    private int[] findPseeHelper(int[] arr, int len){
        int[] pseIndex = new int[arr.length];
        Stack<Integer> stack = new Stack<>();  
        for(int i =0; i<len ; i++){
            while(!stack.empty() && arr[stack.peek()]>=arr[i]) stack.pop();
            pseIndex[i] = stack.empty() ? -1 : stack.peek();
            stack.push(i); 
        }
        return pseIndex;
    }
    private int[] findNseHelper(int[] arr, int len){
        int[] nseIndex = new int[arr.length];
        Stack<Integer> stack = new Stack<>(); 
        for(int i =len-1; i>=0 ; i--){
            while(!stack.empty() && arr[stack.peek()]>arr[i]) stack.pop(); 
            nseIndex[i] = stack.empty() ? len : stack.peek();
            stack.push(i);
        }
        return nseIndex;
    }
    private int[] findPgeeHelper(int[] arr, int len){
        int[] pgeIndex = new int[arr.length];
        Stack<Integer> stack = new Stack<>();  
        for(int i =0; i<len ; i++){
            while(!stack.empty() && arr[stack.peek()]<=arr[i]) stack.pop();
            pgeIndex[i] = stack.empty() ? -1 : stack.peek();
            stack.push(i); 
        }
        return pgeIndex;
    }
    private int[] findNgeHelper(int[] arr, int len){
        int[] ngeIndex = new int[arr.length];
        Stack<Integer> stack = new Stack<>(); 
        for(int i =len-1; i>=0 ; i--){
            while(!stack.empty() && arr[stack.peek()]<arr[i]) stack.pop(); 
            ngeIndex[i] = stack.empty() ? len : stack.peek();
            stack.push(i);
        }
        return ngeIndex;
    }
}
