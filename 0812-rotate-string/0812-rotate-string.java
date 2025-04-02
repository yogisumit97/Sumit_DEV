class Solution {
    public boolean rotateString(String s, String goal) {
        StringBuilder sb = new StringBuilder();
        while(!s.equals(sb.toString())){
            if(sb.length()==0){  // start sb from 1 time shift of s
                sb.append(s.substring(1,s.length()));
                sb.append(s.charAt(0));
            }
            else{
                String str = sb.toString();
                sb.delete(0,sb.length()); //keep shifting sb till it again becomes s
                sb.append(str.substring(1,str.length()));
                sb.append(str.charAt(0));
            }
            if(goal.equals(sb.toString())) return true; // if while shifting goal is reached return true
        }
        return false;
    }
}