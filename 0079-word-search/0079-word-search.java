class Solution {
    public boolean exist(char[][] board, String word) {
        boolean ans = false;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j]==word.charAt(0)){
                    ans = ans || wordSearchHelper(i, j, board.length, board[0].length, board, word, 0);
                    if(ans== true) return ans;
                }
            }
        }
        return false;
    }
    private boolean wordSearchHelper(int i, int j, int row, int col, char[][] board, String word, int index){
        if(index == word.length()) return true;
        if(i<0||j<0||i>=row||j>= col||board[i][j]!=word.charAt(index)) return false;
        char temp = board[i][j];
        board[i][j] = '-';
        if(wordSearchHelper(i, j-1, row, col, board, word, index+1)) return true; //go left
        if(wordSearchHelper(i, j+1, row, col, board, word, index+1)) return true; // go right
        if(wordSearchHelper(i-1, j, row, col, board, word, index+1)) return true; // go up
        if(wordSearchHelper(i+1, j, row, col, board, word, index+1)) return true; // go down
        board[i][j] = temp;
        return false;
    }
}

