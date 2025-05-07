class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;
        for(int i=0; i<visited.length; i++){
            if(!visited[i]){
                traverse(i, visited, isConnected);
                count++;
            }
        }
        return count;
    }
    private void traverse(int node, boolean[] visited, int[][] isConnected){
        if(visited[node]) return;
        visited[node] = true;
        for(int i =0; i<isConnected[0].length; i++){
            int con = isConnected[node][i];
            if(con==1) traverse(i, visited, isConnected);
        }
    }
}