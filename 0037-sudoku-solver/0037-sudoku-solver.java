class Solution {
    public void solveSudoku(char[][] board) {
        sudokuSolverHelper(board, 0);
        return;
    }
    private boolean sudokuSolverHelper(char[][] board, int index){
        if(index>=81) return true;
        int i = index/9;
        int j = index%9;
        if(board[i][j]!='.') return sudokuSolverHelper(board,index+1); //already filled with value thus check for next index
        for(char k='1'; k<='9'; k++){ //empty index thus fill value from 1 to 9 after checking
            if(checkIfValid(board,i,j,k)){ //if valid
                board[i][j] = k;
                if(sudokuSolverHelper(board,index+1)) return true;
                board[i][j] = '.';
            }   
        }
        return false;    
    }
    private boolean checkIfValid(char[][] board, int i, int j, char ch){
        for(int k=0; k<9; k++){
            if(board[i][k]==ch) return false;
            if(board[k][j]==ch) return false;
        }
        int row = (i/3)*3; //check 3*3 for validity
        int col = (j/3)*3;
        for(int x =0; x<3; x++){
            for(int y=0; y<3;y++){
                if(board[row+x][col+y]==ch) return false;
            }
        }
        return true;
    }
}

// 00 01 02       03 04 05     06 07 08

// 10 11 12       13 14 15

// 20 21 22       23 24 25

// 30 31 32