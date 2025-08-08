class Solution {
    public int maxDepth(String s) {
        int max_overall = 0;  //kadane's algorithm types implementation in finding max
        int max_current = 0;
        for(char i : s.toCharArray()){
            if(i=='('){
                max_current++;
                max_overall = Math.max(max_overall,max_current);
            }
            else if(i==')') max_current = Math.max(max_current-1,0);
        }
        return max_overall;
    }
}