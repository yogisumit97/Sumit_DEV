class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //start with any of 0, col-1 or row-1,0 th elements
        int row = 0;
        int col = matrix[0].length-1;
        while(row<matrix.length && col>=0){
            if(matrix[row][col]==target) return true;
            else if(target>matrix[row][col]) row++;
            else col--;
        }
        return false;
    }
}