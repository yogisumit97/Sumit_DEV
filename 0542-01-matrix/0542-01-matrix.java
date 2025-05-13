class Solution {
    private class Pair{
        int i;
        int j;
        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j]==0){
                    q.offer(new Pair(i,j));
                    visited[i][j] = true;
                }
            }
        }
        int[] iDir = new int[]{-1, 1, 0, 0}; //u d l r
        int[] jDir = new int[]{0, 0, -1, 1};
        int dist = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int p=0; p<size; p++){
                Pair pair = q.poll();
                int i = pair.i;
                int j = pair.j;
                mat[i][j] = dist;
                for(int x=0; x<4; x++){
                    int iNew = i + iDir[x];
                    int jNew = j + jDir[x];
                    if(iNew>=0 && jNew>=0 && iNew<n && jNew< m && !visited[iNew][jNew]){
                        q.offer(new Pair(iNew, jNew));
                        visited[iNew][jNew] = true;
                    }
                }
            }
            dist++;
        }
        return mat;
    }
}