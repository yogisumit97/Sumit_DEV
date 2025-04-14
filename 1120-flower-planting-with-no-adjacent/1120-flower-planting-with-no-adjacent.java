class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        int[] flowerInGarden = new int[n]; //default 0 which means no flower in i+1th garden
        return gardeningHelper(1, n, paths, flowerInGarden, 4);
    }
    private int[] gardeningHelper(int currGarden, int totalGardens, int[][] paths, int[] flowerInGarden, int flowers){
        if(currGarden > totalGardens) return flowerInGarden; //if all nodes are colored then we can return
        for(int flower=1; flower<=flowers; flower++){
            if(!isPossibleToUseFlower(currGarden, flower, paths, flowerInGarden)) continue;
            int prevFlower = flowerInGarden[currGarden-1]; // store prev flower of currGarden for backtracking
            flowerInGarden[currGarden-1] = flower; //flower that garden as it is possible to do so.
            int[] arr = gardeningHelper(currGarden+1, totalGardens, paths, flowerInGarden, flowers);
            if(arr.length>0) return arr;
            flowerInGarden[currGarden-1] = prevFlower; // backtracking 
        }
        return new int[]{};
    }
    private boolean isPossibleToUseFlower(int currGarden, int flower, int[][] paths, int[] flowerInGarden){
        int size = paths.length;
        for(int i=0; i<size; i++){
            if(paths[i][0]==currGarden && flowerInGarden[paths[i][1]-1]==flower) return false;
            if(paths[i][1]==currGarden && flowerInGarden[paths[i][0]-1]==flower) return false;
        }
        return true;
    }
}