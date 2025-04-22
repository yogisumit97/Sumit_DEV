class Solution {
    public int maximalRectangle(char[][] matrix) {
        int maxArea = Integer.MIN_VALUE;
        for(int i =0; i<matrix.length; i++){
            int[] heights = new int[matrix[0].length];
            for(int j =0; j<heights.length; j++){
                if(matrix[i][j]=='0') heights[j] = 0;
                else{
                    int k = i;
                    while(k>=0 && matrix[k][j]=='1') k--;
                    heights[j] = i-k;
                }
            }
            maxArea = Math.max(maxArea,largestRectangleArea(heights));
        }
        return maxArea;
    }
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>(); //keeps indexes in Increasing order of heights
        int len = heights.length;
        int maxArea = Integer.MIN_VALUE;
        for(int i =0; i<len; i++){
            while(!stack.empty() && heights[stack.peek()]>heights[i]){
                int currNum = heights[stack.pop()];
                int pseIndex = stack.empty() ? -1 :stack.peek();//after pop,top ele becomes pse;
                maxArea = Math.max(maxArea, currNum*(i-pseIndex-1));// we already know nse is i
            }
            stack.push(i);
        }
        while(!stack.empty()){ // remaining stack had no nse, thus nse = len for calculation
            int currNum = heights[stack.pop()];
            int pseIndex = stack.empty() ? -1 :stack.peek();
            maxArea = Math.max(maxArea, currNum*(len-pseIndex-1));
        }
        return maxArea;
    }
}