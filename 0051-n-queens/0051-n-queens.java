class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }
        nQueenHelper(list, board, 0, n);
        return list;
    }
    private void printBoard(char[][] board, int n){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(board[i][j]+"  ");
            }
            System.out.println();
        }
        System.out.println();
    }
    private void nQueenHelper(List<List<String>> list, char[][] board, int col, int n){
        if(col>=n){
            List<String> res = new ArrayList<>();
            for(int i=0; i<n; i++){
                res.add(new String(board[i]));
            }
            list.add(res);
            return;
        }
        for(int i =0; i<n; i++){
            if(isValidPosition(i, col, board)){
                // backtracking
                board[i][col] = 'Q';
                nQueenHelper(list, board, col+1, n);
                board[i][col] = '.';
            }
        }
    }
    private boolean isValidPosition(int row, int col, char[][] board){
        // check left side 
        for(int j=col-1; j>=0; j--){
            if(board[row][j]=='Q') return false;
        }
        //check upwards
        for(int i=row-1; i>=0; i--){
            if(board[i][col]=='Q') return false;
        }
        // check diagonally upwards
        int i = row-1;
        for(int j=col-1; j>=0; j--){
            if(i<0) break;
            if(board[i][j]=='Q') return false;
            i--;
        }
        // check diagonally downwards
        i = row+1;
        for(int j=col-1; j>=0; j--){
            if(i>=board.length) break;
            if(board[i][j]=='Q') return false;
            i++;
        }
        return true;
    }
}