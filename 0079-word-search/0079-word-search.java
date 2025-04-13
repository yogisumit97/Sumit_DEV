class Solution {
    public boolean exist(char[][] board, String word) {
        boolean ans = false;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j]==word.charAt(0)){
                    ans = ans || wordSearchHelper(i, j, board.length, board[0].length, board, word);
                    if(ans== true) return ans;
                }
            }
        }
        return false;
    }
    private boolean wordSearchHelper(int i, int j, int row, int col, char[][] board, String word){
        if(i<0||j<0||i>=row||j>= col||board[i][j]=='-'|| board[i][j]!=word.charAt(0)) return false;
        if(word.length()==0) return true;
        if(word.length()==1 && board[i][j]==word.charAt(0)) return true;
        char temp = board[i][j];
        board[i][j] = '-';
        if(wordSearchHelper(i, j-1, board.length, board[0].length, board, word.substring(1,word.length()))) return true; //go left
        if(wordSearchHelper(i, j+1, board.length, board[0].length, board, word.substring(1,word.length()))) return true; // go right
        if(wordSearchHelper(i-1, j, board.length, board[0].length, board, word.substring(1,word.length()))) return true; // go up
        if(wordSearchHelper(i+1, j, board.length, board[0].length, board, word.substring(1,word.length()))) return true; // go down
        board[i][j] = temp;
        return false;
    }
}

