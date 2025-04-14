class Solution {
    public List<String> addOperators(String num, int target) {
        char[] operators = {'.','+','-','*'}; //. means no operator in between
        List<String> ans = new ArrayList<>();
        addOperatorsHelper(1, num, new StringBuilder().append(num.charAt(0)), target, operators, ans); 
        return ans;
    }
    private void addOperatorsHelper(int index, String num, StringBuilder result, int target, char[] operators, List<String> ans){
        if(index>=num.length()){
            if(evaluateResultCheck(target, result)) ans.add(result.toString());
            return;
        }
        for(char ch : operators){
            int currentLength = result.length();    
            if(ch == '.' && result.charAt(currentLength-1) == '0') { // Skip concatenation ('.') if creates a leading zero
                if(currentLength == 1 || !Character.isDigit(result.charAt(currentLength-2))) {
                    continue; // Skip to avoid leading zero
                }
            }

            if(ch!='.') result.append(ch); // if . directly append number without any operation
            result.append(num.charAt(index));
            addOperatorsHelper(index+1, num, result, target, operators, ans);
            result.deleteCharAt(result.length()-1);
            if(ch!='.') result.deleteCharAt(result.length()-1);
        }
        return;
    }
    private boolean evaluateResultCheck(int target, StringBuilder result){
        Stack<Long> stack = new Stack<>();
        Stack<Character> operator = new Stack<>();
        for(int i =0; i<result.length();i++){
            char ch = result.charAt(i);
            if(ch=='-' ||ch=='+' ||ch=='*'){
                operator.push(ch);
                continue;
            }
            long num = 0;
            while(i<result.length()){
                ch = result.charAt(i);
                if(ch=='-' ||ch=='+' ||ch=='*'){
                    i = i-1;
                    break;
                }
                num = num*10 + (long)Character.getNumericValue(ch);
                i++;
            }
            if(!operator.empty() && operator.peek()=='*'){
                operator.pop();
                long temp = stack.pop();                
                stack.push(num*temp);
            }
            else stack.push(num);          
        } //end of for loop 
        long temp = 0;
        while(!operator.empty()){
            long number = stack.pop();
            int oper = operator.pop();
            if(oper=='+') temp+=number;
            else temp-=number;
        }
        temp+=stack.pop();
        if(temp==target) return true;
        return false;
    }
}