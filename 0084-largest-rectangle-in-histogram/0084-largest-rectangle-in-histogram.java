class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>(); //keeps indexes in Increasing order of heights
        int len = heights.length;
        int maxArea = Integer.MIN_VALUE;
        for(int i =0; i<len; i++){
            while(!stack.empty() && heights[stack.peek()]>heights[i]){
                int currNum = heights[stack.pop()];
                int pseIndex = -1;
                if(!stack.empty()) pseIndex = stack.peek();//after pop,top ele becomes pse
                // we already know nse is i
                maxArea = Math.max(maxArea, currNum*(i-pseIndex-1));
            }
            stack.push(i);
        }
        while(!stack.empty()){ // remaining stack had no nse, thus nse = len for calculation
            int currNum = heights[stack.pop()];
            int pseIndex = -1;
            if(!stack.empty()) pseIndex = stack.peek();
            maxArea = Math.max(maxArea, currNum*(len-pseIndex-1));
        }
        return maxArea;
    }
}