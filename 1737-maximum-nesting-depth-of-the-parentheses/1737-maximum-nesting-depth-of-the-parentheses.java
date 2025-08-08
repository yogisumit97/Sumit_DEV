class Solution {
    public int maxDepth(String s) {
        int max = 0;
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch== '('){
                stack.push(ch);
                max = Math.max(max, stack.size());
            }
            else if(ch==')'){
                stack.pop();
            }
        }
        return max;
    }
}