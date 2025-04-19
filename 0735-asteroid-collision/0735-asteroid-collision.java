class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int firstPositive = Integer.MAX_VALUE;
        int lastNegative = Integer.MIN_VALUE;
        for(int i=0; i<asteroids.length; i++){
            if(firstPositive==Integer.MAX_VALUE && asteroids[i]>0) firstPositive = i;
            if(asteroids[i]<0) lastNegative = i;
        }
        //System.out.println(firstPositive+ " "+ lastNegative);
        if(firstPositive >  lastNegative) return asteroids;
        for(int i = firstPositive; i<= lastNegative; i++){
            if(stack.empty() || stack.peek()*asteroids[i]>0 || stack.peek()<0){
                stack.push(asteroids[i]);
                //System.out.println("Stack is : "+ stack); 
                continue;
            }
            while(!stack.empty() && stack.peek()*asteroids[i]<0 && Math.abs(stack.peek()) < Math.abs(asteroids[i])) stack.pop();
            if(stack.empty() || stack.peek()*asteroids[i]>0)  stack.push(asteroids[i]);
            else if(Math.abs(stack.peek()) == Math.abs(asteroids[i])) stack.pop();
            //System.out.println("Stack is : "+ stack); 
        }
        int[] result = new int[stack.size()+ firstPositive + asteroids.length - 1- lastNegative];
        int count = 0;
        for(int i =0; i<firstPositive; i++) result[count++] = asteroids[i];
        /*System.out.print("1 >> ");
        for(int i : result) System.out.print(i+" ");
        System.out.println();*/
        for(int i = stack.size()-1; i>=0; i--) result[count+i] = stack.pop();
        count = result.length-1;
        /*System.out.print("2 >> ");
        for(int i : result) System.out.print(i+" ");
        System.out.println();*/
        for(int i =asteroids.length-1 ; i>lastNegative ; i--) result[count--] = asteroids[i];
        /*System.out.print("3 >> ");
        for(int i : result) System.out.print(i+" ");
        System.out.println();*/
        return result;
    }
}