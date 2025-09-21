class Solution {
    class Pair {
        int start;
        int end;
        Pair(int i, int j){
            start = i;
            end = j;
        }
    }
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
        List<Pair> list = new ArrayList<>();
        for(int i =0; i<intervals.length; i++){
            if(list.size()==0 || (intervals[i][0] > list.get(list.size()-1).end)){
                list.add(new Pair(intervals[i][0], intervals[i][1]));
            }
            else{
                Pair temp = list.get(list.size()-1);
                list.remove(list.size()-1);
                temp.end = Math.max(temp.end, intervals[i][1]);
                list.add(temp);
            }
        }
        int[][] mergedIntervals = new int[list.size()][2];
        int i = 0;
        for(Pair p : list){
            mergedIntervals[i][0] = p.start;
            mergedIntervals[i][1] = p.end;
            i++;
        }
        return mergedIntervals;
    }
}