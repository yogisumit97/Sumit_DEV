class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i =0; i<numRows;i++){
            List<Integer> l = new ArrayList<>(i+1);
            for(int j =0; j<i+1;j++) l.add(0);
            l.set(i,1);
            l.set(0,1);
            for(int j = 1;j<=i-1;j++){
                List<Integer> prev = list.get(i-1);
                l.set(j, prev.get(j-1)+prev.get(j));
            }
            list.add(l);
        }
        return list;
    }
}