class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n]; //board[i][j] = '.' means it is empty space and it can be filled with queen
        for(int l = 0; l<board.length; l++){
            for(int r=0; r<board.length; r++) board[l][r] = '.';
        }
        List<List<String>> ans = new ArrayList<>();
        nextQueenPositionHelper(board, 0, ans); 
        return ans;    
    }
    private void nextQueenPositionHelper(char[][] board, int col, List<List<String>> ans){
        if(col>=board.length){
            List<String> result = new ArrayList<>();
            for(int i =0; i<board.length;i++) result.add(new String(board[i]));
            ans.add(new ArrayList<>(result));
            return;
        }
        for(int i=0; i<board.length;i++){ //fill in first row and check further
            if(!checkQueenPossibility(i,col, board,board.length)) continue;
            board[i][col] ='Q'; // place queen at i,col.
            nextQueenPositionHelper(board, col+1, ans);
            board[i][col] ='.'; // replace for backtracking.
        }
    }
    private boolean checkQueenPossibility(int row, int col, char[][] board, int n){ //queen at row,col position
        for(int j = 0; j<col; j++) if(board[row][j]=='Q') return false;// check horizontally.
        for(int i = 0; i<row; i++) if(board[i][col]=='Q') return false;// check vertically. 
        int i= row;
        int j= col;
        while(i>=0 && j>=0 && i<n && j<n){// check diagonally downwards.
            if(board[i][j]=='Q') return false;
            i = i+1;
            j = j-1;
        }
        i= row;
        j= col;
        while(i>=0 && j>=0 && i<n && j<n){// check diagonally upwards.
            if(board[i][j]=='Q') return false;
            i = i-1;
            j = j-1;
        }
        return true;
    }
}