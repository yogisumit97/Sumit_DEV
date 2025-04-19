class Solution {
    public int sumSubarrayMins(int[] arr) {
        int len = arr.length;
        int[] pseIndex = new int[arr.length];// stores previous smaller or equal element index
        int[] nseIndex = new int[arr.length];// stores next smaller or equal element index
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
            while(!stack.empty() && arr[stack.peek()]>arr[i]) stack.pop();
            if(!stack.empty()) res = stack.peek();
            stack.push(i);
            nseIndex[i] = res;
        }
        long sum = 0;
        for(int i =0; i<len ; i++){
            sum+= ((long)arr[i]*(i-pseIndex[i])*(nseIndex[i]-i));
        }
        return (int)(sum%(1e9+7));
    }
}