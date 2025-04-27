class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> list = new ArrayList<>();
        int count = 0;
        for(int[] arr : intervals){
            if(count ==0 && arr[0]> newInterval[0]){
                List<Integer> li = new ArrayList<>();
                li.add(newInterval[0]);li.add(newInterval[1]); list.add(li); //add new Interval 
                count = 1;
            }
            List<Integer> l = new ArrayList<>();
            l.add(arr[0]);l.add(arr[1]); list.add(l); //add element
        }
        if(count ==0){
            List<Integer> li = new ArrayList<>();
            li.add(newInterval[0]);li.add(newInterval[1]); list.add(li); //add new Interval 
        }
        int i =1;
        while(i<list.size()){
            List<Integer> curr = list.get(i);
            List<Integer> prev = list.get(i-1);
            if(prev.get(1)>=curr.get(0)){
                list.get(i-1).set(1, Math.max(curr.get(1), prev.get(1)));
                list.remove(i);
            }
            else i++;
        }
        int[][] mat = new int[list.size()][2];
        for(i =0; i<list.size(); i++){
            mat[i][0] = list.get(i).get(0);
            mat[i][1] = list.get(i).get(1);
        }
        return mat;
    }
}