class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> list = new ArrayList<>();
        int i =0;
        int len = intervals.length;
        while(i< len && newInterval[0] > intervals[i][1]){ // left most part where no overlap
            List<Integer> l = new ArrayList<>();
            l.add(intervals[i][0]); l.add(intervals[i][1]); list.add(l); 
            i++;
        }
        while(i< len && newInterval[1] >= intervals[i][0]){ // middle part where overlap 
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        List<Integer> li = new ArrayList<>();
        li.add(newInterval[0]); li.add(newInterval[1]); list.add(li); 
        while(i< len && newInterval[1] < intervals[i][0]){ // right most part where no overlap
            List<Integer> l = new ArrayList<>();
            l.add(intervals[i][0]); l.add(intervals[i][1]); list.add(l); 
            i++;
        }
        int[][] mat = new int[list.size()][2];
        for(i =0; i<list.size(); i++){
            mat[i][0] = list.get(i).get(0);
            mat[i][1] = list.get(i).get(1);
        }
        return mat;
    }
}