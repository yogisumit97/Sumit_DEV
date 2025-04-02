class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" +"); //splitting string into strings using regex
        StringBuilder ans = new StringBuilder();
        for(int i=words.length-1; i>=0;i--){
            ans.append(words[i]);
            ans.append(' ');
        }
        return ans.toString().trim(); // trim removes leading and trailing whitespaces
    }
}
