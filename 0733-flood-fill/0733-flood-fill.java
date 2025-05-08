class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) { // using BFS
        int n = image.length;
        int m = image[0].length;
        Queue<Pair<Integer,Integer>> q = new LinkedList<>();
        int startColor = image[sr][sc];
        if(startColor == color) return image;
        image[sr][sc] = color;
        q.offer(new Pair<>(sr,sc));
        int[] dRow = new int[]{-1, 1, 0, 0}; // up down left right
        int[] dCol = new int[]{0, 0, -1, 1};
        while(!q.isEmpty()){
            Pair<Integer, Integer> pair = q.poll();
            int row = pair.getKey();
            int col = pair.getValue();
            for(int i=0; i<4; i++){
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];
                if(nRow>=0 && nCol>=0 && nRow<n && nCol<m && image[nRow][nCol]==startColor){
                    image[nRow][nCol] = color;
                    q.offer(new Pair<>(nRow, nCol));
                }
            }
        }
        return image;
    }
}