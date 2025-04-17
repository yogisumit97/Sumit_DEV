class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] max = new int[nums2.length];
        Stack<Integer> stack = new Stack<>(); //keeps track of next max
        int count = nums2.length-1;
        while(count>=0){
            if(stack.empty()){
                stack.push(nums2[count]);
                max[count] = -1;
            }
            else{
                if(stack.peek()>nums2[count]){
                    max[count]= stack.peek();
                    stack.push(nums2[count]);
                }
                else{
                    while(!stack.empty() && stack.peek()<nums2[count]){
                        stack.pop();
                    }
                    if(stack.empty()){
                        max[count]=-1;
                    }
                    else{
                        max[count]= stack.peek();
                    }
                    stack.push(nums2[count]);
                }
            }
            count--;
        }
        int[] ans = new int[nums1.length];
        for(int i =0; i<nums2.length; i++){
            for(int j=0; j<nums1.length; j++){
                if(nums1[j]==nums2[i]){
                    ans[j]=max[i];
                }
            }
        }
        return ans;
    }
}
