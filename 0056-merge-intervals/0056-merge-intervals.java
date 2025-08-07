class Solution {
    public int[][] merge(int[][] intervals) {
        //sort acc to first column 
        sortByColumn(intervals, 0);
        // now start is in ascending order so merge in list accordingly
        List<List<Integer>> list = new ArrayList<>();
        int currRow = 0;
        while(currRow!=intervals.length){
            if(list.size()==0 || list.get(list.size()-1).get(1) < intervals[currRow][0]){
                List<Integer> l = new ArrayList<>();
                l.add(intervals[currRow][0]);
                l.add(intervals[currRow][1]);
                list.add(l);
            }
            else{
                if(list.get(list.size()-1).get(1) >= intervals[currRow][0] && list.get(list.size()-1).get(1) < intervals[currRow][1] ){
                    // update list
                    List<Integer> l = new ArrayList<>();
                    l.add(list.get(list.size()-1).get(0));
                    l.add(intervals[currRow][1]);
                    list.set(list.size()-1, l);
                }
            }
            currRow++;
        }
        //convert list to 2d array and return
        return listToArray(list);
    }
    private void sortByColumn(int[][] intervals, int col){
         Arrays.sort(intervals, (a, b) -> Integer.compare(a[col], b[col]));
    }
    private int[][] listToArray(List<List<Integer>> list){
        int[][] intervals = new int[list.size()][2];
        int row = 0;
        for(List<Integer> l : list){
            intervals[row][0] = l.get(0);
            intervals[row][1] = l.get(1);
            row++;
        }
        return intervals;
    }
    private void printMatrix(int[][] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}