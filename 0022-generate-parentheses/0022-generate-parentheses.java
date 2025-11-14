class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(n,n, new StringBuilder(), result);
        return result;
    }
    private void helper(int open, int close, StringBuilder sb, List<String> result){
        if(open ==0 && close ==0){
            result.add(new String(sb));
            return;
        }
        if(close < open || close<0 || open<0) return;

        sb.append('(');
        helper(open-1, close, sb, result);
        sb.deleteCharAt(sb.length()-1);
        sb.append(')');
        helper(open, close-1, sb, result);
        sb.deleteCharAt(sb.length()-1);
    }
}