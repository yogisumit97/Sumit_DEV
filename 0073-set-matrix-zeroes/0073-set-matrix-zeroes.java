class Solution {
    public void setZeroes(int[][] matrix) {
        // constant space solution
        int row0 = 1;
        int n = matrix.length; // n*m matrix
        int m = matrix[0].length;
        for(int i=0;i<n; i++){
            for(int j=0;j<m; j++){
                if(matrix[i][j] ==0){
                    matrix[0][j] = 0;
                    if(i!=0){
                        matrix[i][0] = 0;
                    }
                    else row0 = 0;
                }
            }
        }
        for(int i=n-1;i>=1; i--){
            for(int j=m-1;j>=0; j--){
                if(matrix[i][0]==0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(row0==0){
            for(int j=0; j<m; j++){
                matrix[0][j] = 0;
            }
        }
    }
}