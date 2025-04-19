class Solution {
    public int sumSubarrayMins(int[] arr) {
        int len = arr.length;
        int[] pseIndex = new int[arr.length];// stores previous smaller or equal element index
        int[] nseIndex = new int[arr.length];// stores next smaller index, not equal to avoid double counting of similar elements
        Stack<Integer> stack = new Stack<>();  //to get PSE and NSE
        for(int i =0; i<len ; i++){
            int res = -1;
            while(!stack.empty() && arr[stack.peek()]>=arr[i]) stack.pop();
            if(!stack.empty()) res = stack.peek();
            stack.push(i);
            pseIndex[i] = res;
        }
        stack.clear();
        for(int i =len-1; i>=0 ; i--){
            int res = len;
            while(!stack.empty() && arr[stack.peek()]>arr[i]) stack.pop(); // only greater check and not equal as in pse to avoid double taking similar elements for ex check with array :   {1,1} >> if it is not done answer comes 4 whereas it should be 3
            if(!stack.empty()) res = stack.peek();
            stack.push(i);
            nseIndex[i] = res;
        }
        long sum = 0;
        for(int i =0; i<len ; i++){
            sum+= (1L*arr[i]*(i-pseIndex[i])*(nseIndex[i]-i)); //multiply with 1L to avoid overfow of integer calculations 
        }
        return (int)(sum%(1e9+7));
    }
}