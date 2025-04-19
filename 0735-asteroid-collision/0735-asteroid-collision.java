class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i< asteroids.length; i++){
            if(stack.empty() || stack.peek()*asteroids[i]>0 || stack.peek()<0){
                stack.push(asteroids[i]);
                continue;
            }
            while(!stack.empty() && stack.peek()*asteroids[i]<0 && Math.abs(stack.peek()) < Math.abs(asteroids[i])) stack.pop();
            if(stack.empty() || stack.peek()*asteroids[i]>0)  stack.push(asteroids[i]);
            else if(Math.abs(stack.peek()) == Math.abs(asteroids[i])) stack.pop();
        }
        int[] result = new int[stack.size()];
        for(int i =stack.size()-1; i>=0; i--) result[i] = stack.pop();
        return result;
    }
}