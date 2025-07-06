class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        partitionHelper(s, 0, new ArrayList<String>(), list);
        return list;
    }
    private void partitionHelper(String s, int index, List<String> result, List<List<String>> list){
        if(index>=s.length()){
            list.add(new ArrayList<>(result));
            return;
        }
        for(int i=index+1; i<=s.length(); i++){
            if(palindromeCheck(s.substring(index, i))){
                result.add(s.substring(index,i));
                partitionHelper(s,i,result,list);
                result.remove(result.size()-1);
            }
        }
    }
    private boolean palindromeCheck(String s){
        int left = 0;
        int right = s.length()-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}