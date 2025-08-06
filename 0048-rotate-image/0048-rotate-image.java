class Solution {
    public void rotate(int[][] matrix) {
        // first transporse then reverse rows
        transporse(matrix);
        reverseMatrix(matrix);
    }
    public void transporse(int[][] matrix){
        for(int i=0; i<matrix.length; i++){
            for(int j=i+1; j<matrix.length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    public void reverseMatrix(int[][] matrix){
        int left = 0;
        int right = matrix.length-1;

        while(left<right){
            for(int i=0; i<matrix[0].length; i++){
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
            }
            left++;
            right--;
        }
    }
}