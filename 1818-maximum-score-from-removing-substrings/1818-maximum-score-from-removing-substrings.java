class Solution {
    public int maximumGain(String s, int x, int y) {
        int sum = 0;
        StringBuilder sb = new StringBuilder(s);
        if(x>=y)    sum = remove(sb, "ab", x) + remove(sb, "ba", y);
        else    sum = remove(sb, "ba", y) + remove(sb, "ab", x);
        return sum;
    }
    private int remove(StringBuilder sb, String s, int x){
        int sum = 0;
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<sb.length();i++){
            if(sb.charAt(i)==s.charAt(1) &&(!stack.empty() && stack.peek()==s.charAt(0))){
                sum+=x;
                stack.pop();
            }
            else stack.push(sb.charAt(i));
        }
        sb.setLength(0);
        while(!stack.empty()) sb.append(stack.pop());
        sb.reverse();
        return sum;
    }
}