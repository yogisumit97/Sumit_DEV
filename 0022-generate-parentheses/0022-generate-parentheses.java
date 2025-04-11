class Solution {
    public List<String> generateParenthesis(int n) {
        return generateParenthesisHelper(1,2*n,"(",new ArrayList<String>(),1,0);
    }
    private List<String> generateParenthesisHelper(int index, int size, String result, List<String> ans,int openCount, int closeCount){
        // If the number of open or close parentheses exceeds n or if close parentheses exceed open parentheses, the combination is invalid."
        if(openCount>size/2 || closeCount>size/2 || openCount<closeCount) return ans;
        if(index>=size){
            ans.add(result.toString());
            return ans;
        }
        generateParenthesisHelper(index+1, size, result+'(', ans,openCount+1,closeCount);
        generateParenthesisHelper(index+1, size, result+')', ans,openCount, closeCount+1);
        return ans;
    }
}