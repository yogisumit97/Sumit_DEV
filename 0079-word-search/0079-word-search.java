class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                boolean[][] used = new boolean[board.length][board[0].length];
                if(helper(board, i, j, word, 0, used)) return true;
            }
        }
        return false;
    }
    private boolean helper(char[][] board, int i, int j, String word, int index, boolean[][] used){
        if(index>=word.length()) return true;
        if(i<0 || j<0 || i>=board.length || j>=board[0].length) return false;
        if(used[i][j]){
            return false;
        }
        if(board[i][j]!=word.charAt(index)) return false;
        // if matched : try U D L R with backtracking 
        used[i][j] = true;
        if(helper(board, i-1, j, word, index+1, used)) return true;
        if(helper(board, i+1, j, word, index+1, used)) return true;
        if(helper(board, i, j-1, word, index+1, used)) return true;
        if(helper(board, i, j+1, word, index+1, used)) return true;
        used[i][j] = false;
        return false;
    }
}