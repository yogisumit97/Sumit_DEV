class Solution {
    public int orangesRotting(int[][] grid) { // using BFS
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<Pair<Integer,Integer>> q = new LinkedList<>();
        boolean rottenExists = false;
        boolean freshExists = false;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){ // put all rotten in queue initially.
                if(grid[i][j]==2){
                    q.offer(new Pair(i,j));
                    visited[i][j] = true;
                    rottenExists = true;
                }
                else if(grid[i][j]==1) freshExists = true;
            }
        }
        if(freshExists == false) return 0;
        if(rottenExists == false) return -1;
        int maxTime = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int index=0; index<size; index++){
                Pair<Integer,Integer> pair = q.poll();
                int i = pair.getKey();
                int j = pair.getValue();
                if(j-1 >=0 && grid[i][j-1]==1){// left case
                    grid[i][j-1] = 2; // mark rotten
                    visited[i][j-1] = true;
                    q.offer(new Pair(i,j-1));
                }
                if(j+1 < grid[0].length && grid[i][j+1]==1){//right case
                    grid[i][j+1] = 2; // mark rotten
                    visited[i][j+1] = true;
                    q.offer(new Pair(i,j+1));
                }
                if(i-1 >=0 && grid[i-1][j]==1){// up case
                    grid[i-1][j] = 2; // mark rotten
                    visited[i-1][j] = true;
                    q.offer(new Pair(i-1,j));
                }
                if(i+1 < grid.length && grid[i+1][j]==1){// down case
                    grid[i+1][j] = 2; // mark rotten
                    visited[i+1][j] = true;
                    q.offer(new Pair(i+1,j));
                }
            }
            maxTime++;
        }
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){ // put all rotten in queue initially.
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return maxTime-1;
    }
}