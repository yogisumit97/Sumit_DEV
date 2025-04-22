class Solution {
    public int maximalRectangle(char[][] matrix) {
        int maxArea = Integer.MIN_VALUE;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] mat = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){ // store prefix sum
                if(i==0){
                    mat[i][j] = (int)(matrix[i][j]-'0');
                }
                else if(matrix[i][j]=='0'){
                    mat[i][j] = 0;
                }
                else mat[i][j] = mat[i-1][j]+1;
            }
        }
        for(int i =0; i<m; i++){
            maxArea = Math.max(maxArea,largestRectangleArea(mat[i]));
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