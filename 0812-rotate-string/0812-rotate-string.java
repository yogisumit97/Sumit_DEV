class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!= goal.length()) return false;
        else if((s+s).contains(goal)) return true; //s+s contains all possible rotations so check goal in it
        else return false;
    }
}