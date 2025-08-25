class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left = 0;
        int right = matrix[0].length-1;
        int up = 0;
        int down = matrix.length-1;
        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<>();
        while(left<=right && up<=down){
            j = left;
            while(j <= right){
                list.add(matrix[up][j]);
                j++;
            }
            up++;
            i = up;
            while(i <= down){
                list.add(matrix[i][right]);
                i++;
            }
            right--;
            if(up<=down){
                j = right;
                while(j>=left){
                    list.add(matrix[down][j]);
                    j--;
                }
                down--;
            }
            i = down;
            if(left<=right){
                while(i>=up){
                    list.add(matrix[i][left]);
                    i--;
                }
                left++;
            }
        }
        return list;
    }
}