class Solution {
    public List<String> generateParenthesis(int n) {
        return generateValidCombinations(1,2*n,"(",new ArrayList<String>(),1,0);
    }
    public List<String> generateValidCombinations(int index, int size, String result, List<String> ans,int open, int close){
        if(open>size/2 || close>size/2 || open<close) return ans;
        if(index>=size){
            ans.add(new String(result));
            return ans;
        }
        generateValidCombinations(index+1, size, result+'(', ans,open+1,close);
        generateValidCombinations(index+1, size, result+')', ans,open, close+1);
        return ans;
    }
}