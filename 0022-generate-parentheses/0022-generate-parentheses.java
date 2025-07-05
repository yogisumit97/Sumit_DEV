class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        gPHelper(n, n, new String(), list);
        return list;
    }
    private void gPHelper(int open, int close, String res, List<String> list){
        if(open ==0 && close ==0){
            list.add(res);
            return;
        }
        if(open > close) return;
        if(open>0) gPHelper(open-1, close, res+"(", list);
        if(close>0) gPHelper(open, close-1, res+")", list);
    }
}