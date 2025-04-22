class Solution {
    public int maximalRectangle(char[][] matrix) {
        int maxArea = Integer.MIN_VALUE;
        for(int i=1; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){ // store prefix sum
                if(matrix[i][j]=='0') continue;
                matrix[i][j] = (char)(matrix[i-1][j]+1);
            }
        }
        for(int i =0; i<matrix.length; i++){
            maxArea = Math.max(maxArea,largestRectangleArea(matrix[i]));
        }
        return maxArea;
    }
    public int largestRectangleArea(char[] heights) {
        Stack<Integer> stack = new Stack<>(); //keeps indexes in Increasing order of heights
        int len = heights.length;
        int maxArea = Integer.MIN_VALUE;
        for(int i =0; i<len; i++){
            while(!stack.empty() && heights[stack.peek()]>heights[i]){
                int currNum = heights[stack.pop()]-'0';
                int pseIndex = stack.empty() ? -1 :stack.peek();//after pop,top ele becomes pse;
                maxArea = Math.max(maxArea, currNum*(i-pseIndex-1));// we already know nse is i
            }
            stack.push(i);
        }
        while(!stack.empty()){ // remaining stack had no nse, thus nse = len for calculation
            int currNum = heights[stack.pop()]-'0';
            int pseIndex = stack.empty() ? -1 :stack.peek();
            maxArea = Math.max(maxArea, currNum*(len-pseIndex-1));
        }
        return maxArea;
    }
}