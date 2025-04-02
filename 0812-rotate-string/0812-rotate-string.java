class Solution {
    public boolean rotateString(String s, String goal) {
        StringBuilder sb = new StringBuilder();
        while(!s.equals(sb.toString())){
            if(sb.length()==0){
                sb.append(s.substring(1,s.length()));
                sb.append(s.charAt(0));
                //System.out.println(sb);
            }
            else{
                String str = sb.toString();
                sb.delete(0,sb.length());
                sb.append(str.substring(1,str.length()));
                sb.append(str.charAt(0));
                //System.out.println(sb);
            }
            if(goal.equals(sb.toString())) return true;
        }
        return false;
    }
}