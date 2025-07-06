class Solution {
    private Boolean dp[][];
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        dp = new Boolean[s.length()][s.length()];
        partitionHelper(s, 0, new ArrayList<String>(), list);
        return list;
    }
    private void partitionHelper(String s, int index, List<String> result, List<List<String>> list){
        if(index>=s.length()){
            list.add(new ArrayList<>(result));
            return;
        }
        for(int i=index+1; i<=s.length(); i++){
            if(palindromeCheck(s, index, i-1)){
                result.add(s.substring(index,i));
                partitionHelper(s,i,result,list);
                result.remove(result.size()-1);
            }
        }
    }
    private boolean palindromeCheck(String s, int start, int end){
        if(dp[start][end]!=null) return dp[start][end];
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return dp[start][end] = false;
            }
            start++;
            end--;
        }
        return dp[start][end] = true;
    }
}