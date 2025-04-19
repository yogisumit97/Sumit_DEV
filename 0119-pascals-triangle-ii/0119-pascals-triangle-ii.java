class Solution {
    public List<Integer> getRow(int rowIndex) {
        return getRowHelper(1, rowIndex, new ArrayList<Integer>());
    }
    private List<Integer> getRowHelper(int currIndex, int rowIndex, List<Integer> list){
        if(currIndex>rowIndex+1) return list;
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<currIndex; i++) ans.add(0);
        ans.set(0,1);
        ans.set(currIndex-1,1);
        for(int i = 1; i< list.size(); i++){
            ans.set(i, list.get(i)+list.get(i-1));
        }
        return getRowHelper(currIndex+1, rowIndex, ans);
    }
}