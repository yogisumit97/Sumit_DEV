class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) { // using BFS
        int n = image.length;
        int m = image[0].length;
        Queue<int[]> q = new LinkedList<>();
        int startColor = image[sr][sc];
        if(startColor == color) return image;
        image[sr][sc] = color;
        q.offer(new int[]{sr,sc});
        int[] dRow = new int[]{-1, 1, 0, 0}; // up down left right
        int[] dCol = new int[]{0, 0, -1, 1};
        while(!q.isEmpty()){
            int[] cell = q.poll();
            for(int i=0; i<4; i++){
                int nRow = cell[0] + dRow[i];
                int nCol = cell[1] + dCol[i];
                if(nRow>=0 && nCol>=0 && nRow<n && nCol<m && image[nRow][nCol]==startColor){
                    image[nRow][nCol] = color;
                    q.offer(new int[] {nRow, nCol});
                }
            }
        }
        return image;
    }
}