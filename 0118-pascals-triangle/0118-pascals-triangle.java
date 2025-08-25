class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1));
        if(numRows<=1) return list;
        list.add(Arrays.asList(1,1));
        if(numRows ==2) return list;
        for(int i=3; i<=numRows; i++){
            List<Integer> l = new ArrayList<>();
            l.add(1);
            for(int j=1; j<i-1; j++){
                l.add(list.get(i-2).get(j-1)+list.get(i-2).get(j));
            }
            l.add(1);
            list.add(l);
        }
        return list;
    }
}