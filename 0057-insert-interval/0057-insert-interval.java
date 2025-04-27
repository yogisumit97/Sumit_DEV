class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length==0){
            int[][] mat = new int[1][newInterval.length];
            mat[0][0] = newInterval[0];
            mat[0][1] = newInterval[1];
            return mat;
        }
        List<List<Integer>> list = new ArrayList<>();
        int count = 0;
        for(int[] interval : intervals){ //interval[0] start time and interval[1] endTime
            List<Integer> l = new ArrayList<>();  
            if(count ==0 && newInterval[0]<interval[0] && newInterval[1]<interval[0]){
                List<Integer> li = new ArrayList<>();
                li.add(newInterval[0]);
                li.add(newInterval[1]);
                list.add(li);
                count = 1;
            }
            if(count==0 && newInterval[0] <=interval[1]){
                int startTime = Math.min(interval[0], newInterval[0]);
                int endTime = Math.max(interval[1], newInterval[1]);
                l.add(startTime);
                l.add(endTime);
                count = 1;
            }
            else{
                l.add(interval[0]);  
                l.add(interval[1]);
            }
            list.add(l);
        }
        if(count==0){
            List<Integer> l = new ArrayList<>();
            l.add(newInterval[0]);
            l.add(newInterval[1]);
            list.add(l);
        }
        //System.out.println(list);
        int i =1;
        while(i<list.size()){
            List<Integer> curr = list.get(i);
            List<Integer> prev = list.get(i-1);
            if(prev.get(1) < curr.get(0)){
                i++;
                continue;
            }
            else{
                List<Integer> l = new ArrayList<>();
                l.add(Math.min(prev.get(0), curr.get(0)));
                l.add(Math.max(prev.get(1), curr.get(1)));
                list.remove(i-1);
                list.remove(i-1);
               // System.out.println(list);
                list.add(i-1, l);
            }
           // System.out.println(prev+" "+curr+" "+"List : "+list);
        }
        //System.out.println(list);
        int size = list.size();
        int[][] mat = new int[size][2];
        for(i =0; i<size; i++){
            mat[i][0] = list.get(i).get(0); 
            mat[i][1] = list.get(i).get(1);
        }
        return mat;
    }
}