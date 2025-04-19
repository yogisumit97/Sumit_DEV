class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int firstPositive = Integer.MAX_VALUE;
        int lastNegative = Integer.MIN_VALUE;
        for(int i=0; i<asteroids.length; i++){
            if(firstPositive==Integer.MAX_VALUE && asteroids[i]>0) firstPositive = i;
            if(asteroids[i]<0) lastNegative = i;
        }
        if(firstPositive >  lastNegative) return asteroids;
        for(int i = firstPositive; i<= lastNegative; i++){
            if(stack.empty() || stack.peek()*asteroids[i]>0 || stack.peek()<0){
                stack.push(asteroids[i]);
                continue;
            }
            while(!stack.empty() && stack.peek()*asteroids[i]<0 && Math.abs(stack.peek()) < Math.abs(asteroids[i])) stack.pop();
            if(stack.empty() || stack.peek()*asteroids[i]>0)  stack.push(asteroids[i]);
            else if(Math.abs(stack.peek()) == Math.abs(asteroids[i])) stack.pop();
        }
        int[] result = new int[stack.size()+ firstPositive + asteroids.length - 1- lastNegative];
        int count = 0;
        for(int i =0; i<firstPositive; i++) result[count++] = asteroids[i];
        for(int i = stack.size()-1; i>=0; i--) result[count+i] = stack.pop();
        count = result.length-1;
        for(int i =asteroids.length-1 ; i>lastNegative ; i--) result[count--] = asteroids[i];
        return result;
    }
}