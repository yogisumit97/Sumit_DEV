class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        palindromePartitionHelper(0, s,new ArrayList<String>(), ans);
        return ans;
    }
    private void palindromePartitionHelper(int index, String s, List<String> result, List<List<String>> ans){
        if(index>=s.length()){
            ans.add(new ArrayList<>(result));
            return;
        }
        for(int i =index+1; i<=s.length();i++){
            String left_partition = s.substring(index,i);
            if(checkPalindrome(left_partition)){
                result.add(left_partition);
                palindromePartitionHelper(i, s, result, ans);
                result.remove(result.size()-1);
            } 
        }
    }
    private boolean checkPalindrome(String s){
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