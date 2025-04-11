class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length()==0) return ans;
        return findCombinations(0, digits,"", ans);
    }
    public List<String> findCombinations(int index, String digits, String result, List<String> ans){
            if(index>=digits.length()){
                ans.add(new String(result));
                return ans;
            }
            String curr="";
            switch(digits.charAt(index)){
                case '2' : curr = "abc"; break;
                case '3' : curr = "def"; break;
                case '4' : curr = "ghi"; break;
                case '5' : curr = "jkl"; break;
                case '6' : curr = "mno"; break;
                case '7' : curr = "pqrs"; break;
                case '8' : curr = "tuv"; break;
                case '9' : curr = "wxyz"; break;
            }
            for(int i=0; i<curr.length(); i++){
                result = result+curr.charAt(i);
                findCombinations(index+1, digits,result, ans);
                result = result.substring(0,result.length()-1);
            }
            return ans;
    }
}