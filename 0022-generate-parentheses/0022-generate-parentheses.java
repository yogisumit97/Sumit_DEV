class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        return generateValidCombinations(1,2*n,"(",ans);
    }
    public List<String> generateValidCombinations(int index, int size, String result, List<String> ans){
        if(index>=size){
            if(checkValid(result,size)) ans.add(new String(result));
            return ans;
        }
        else if(checkValid(result,size)){
            generateValidCombinations(index+1, size, result+'(', ans);
            generateValidCombinations(index+1, size, result+')', ans);
        }
        return ans;
    }
    public boolean checkValid(String result, int size){
        if(result.length()==0) return true;
        int count1 = 0;
        int count2 = 0;
        for(int i =0;i<result.length();i++){
            if(result.charAt(i)=='(') count1++;
            else count2++;
        }
        if(count1>size/2 || count2>size/2) return false;
        else if(count1<count2) return false;
        return true;
    }
}