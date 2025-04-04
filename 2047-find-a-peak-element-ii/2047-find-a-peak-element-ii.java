class Solution {
    public int findRowOfMaxElement(int[][] mat,int rows, int col){
        int maxIndex = -1;
        int max = 0;
        for(int i=0;i<rows;i++){
            if(mat[i][col]>max){
                max = mat[i][col];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    public int[] findPeakGrid(int[][] mat) {
        int rows = mat.length; // no. of rows
        int columns = mat[0].length; //no.of columns
        //we will apply binary search on no. of columns to eliminate left or right side of columns 
        int low = 0;
        int high = columns-1;
        while(low<=high){
            int mid = (low+high)/2; //in this column find max. element
            int maxRow = findRowOfMaxElement(mat,rows,mid);
            int max = mat[maxRow][mid];
            //as max element is always greater in whole column thus only left right check is needed
            int left = mid-1>=0 ? mat[maxRow][mid-1] : -1;
            int right = mid+1<columns ? mat[maxRow][mid+1] : -1;
            if(left < max && right < max) return new int[] {maxRow,mid}; //found peek
            else if(left > max) high = mid-1; // as left side big thus peek towards left side
            else low = mid+1; 
        }
        return new int[] {-1,-1};
    }
}