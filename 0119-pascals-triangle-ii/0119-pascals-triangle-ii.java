class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        if(rowIndex==0) return list;
        list.add(rowIndex);
        for(int i =2; i<=rowIndex; i++){
            list.add((int)(list.get(i-1)*(long)(rowIndex-i+1)/(i)));
        }
        return list;
    }
}
