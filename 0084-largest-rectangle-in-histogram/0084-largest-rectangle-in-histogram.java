class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] pseeIndex = findPseeHelper(heights, len);
        int[] nseeIndex = findNseeHelper(heights, len);
        int maxArea = Integer.MIN_VALUE;
        for(int i =0; i<heights.length; i++){
            int currArea = heights[i] * (nseeIndex[i]-pseeIndex[i]-1);
            maxArea = Math.max(maxArea, currArea);
        }
        return maxArea;
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
    private int[] findNseeHelper(int[] arr, int len){
        int[] nseIndex = new int[arr.length];
        Stack<Integer> stack = new Stack<>();  
        for(int i =len-1; i>=0 ; i--){
            while(!stack.empty() && arr[stack.peek()]>=arr[i]) stack.pop(); 
            nseIndex[i] = stack.empty() ? len : stack.peek();
            stack.push(i);
        }
        return nseIndex;
    }
}
 