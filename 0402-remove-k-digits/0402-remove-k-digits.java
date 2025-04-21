class Solution {
    public String removeKdigits(String num, int k) {
        if(k>=num.length()) return "0";
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(int i =0; i<num.length(); i++){
            while(!stack.empty() && stack.peek()>num.charAt(i)){
                if(k==0) break;
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        while(k!=0 && !stack.empty()){
            stack.pop();
            k--;
        }
        while(!stack.empty()){
            sb.append(stack.pop());
        }
        //System.out.println(stack);
        sb.reverse();
        int temp = 0;
        while(sb.length()>0 && sb.charAt(temp)=='0') sb.deleteCharAt(temp);
        //System.out.println(sb);
        if(sb.length()==0) return "0";
        return sb.toString();
    }
}