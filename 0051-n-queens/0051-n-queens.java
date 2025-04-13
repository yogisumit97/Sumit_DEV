class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n]; //board[i][j] = 0 means it is empty space and it can be filled with queen
        List<List<String>> ans = new ArrayList<>();
        nextQueenPositionHelper(board, 0, ans);
        return ans;    
    }
    private void nextQueenPositionHelper(char[][] board, int j, List<List<String>> ans){
        if(j>=board.length){
            List<String> result = new ArrayList<>();
            for(int i =0; i<board.length;i++){
                result.add(new String(board[i]));
            }
            ans.add(new ArrayList<>(result));
            return;
        }
        for(int i=0; i<board.length;i++){ //fill in first row and check further
            if(board[i][j]=='.') continue; //already attacked position
            char[][] temp = new char[board.length][board.length];
            for(int l = 0; l<board.length; l++){
                for(int r=0; r<board.length; r++) temp[l][r] = board[l][r];
            }
            markBoardAttacked(board, i, j, board.length);
            board[i][j] ='Q'; // place queen at i,j
            nextQueenPositionHelper(board, j+1, ans);
            for(int l = 0; l<board.length; l++){  //unmark attacked positions.
                for(int r=0; r<board.length; r++) board[l][r] = temp[l][r];
            }
        }
        return;
    }
    private void markBoardAttacked(char[][] board, int i, int j, int n){ //queen at i,j position, mark relevant pos as '.'
        for(int k = 0; k<n; k++) board[i][k] = '.';// mark horizontally.
        for(int k = 0; k<n; k++) board[k][j] = '.';// mark vertically. 
        int l= i;
        int r= j;
        while(l>=0 && r>=0 && l<n && r<n){// mark diagonally downwards.
            board[l][r] = '.';
            l = l+1;
            r = r+1;
        }
        l= i;
        r= j;
        while(l>=0 && r>=0 && l<n && r<n){// mark diagonally downwards.
            board[l][r] = '.';
            l = l-1;
            r = r+1;
        }
    }
}