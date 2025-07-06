class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if(digits.length()==0) return list;
        lCHelper(digits, 0, new StringBuilder(), list);
        return list;
    }
    private void lCHelper(String digits, int i, StringBuilder sb, List<String> list){
        if(i>=digits.length()){
            list.add(new String(sb));
            return;
        }
        String curr = getString(digits.charAt(i));
        for(int j=0; j<curr.length(); j++){
            sb.append(curr.charAt(j));
            lCHelper(digits, i+1, sb, list);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    private String getString(char ch){
        switch(ch){
            case '2': return "abc";
            case '3': return "def";
            case '4': return "ghi";
            case '5': return "jkl";
            case '6': return "mno";
            case '7': return "pqrs";
            case '8': return "tuv";
            case '9': return "wxyz";
        }
        return "";
    }
}