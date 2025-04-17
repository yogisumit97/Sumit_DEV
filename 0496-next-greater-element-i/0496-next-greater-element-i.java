class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>(); //keeps track of next max
        int count = nums2.length-1;
        HashMap<Integer,Integer> hm = new HashMap<>();
        while(count>=0){
            int temp = -1;
            if(stack.empty()){
                stack.push(nums2[count]);
                temp = -1;
            }
            else{
                if(stack.peek()>nums2[count]){
                    temp= stack.peek();
                    stack.push(nums2[count]);
                }
                else{
                    while(!stack.empty() && stack.peek()<nums2[count]){
                        stack.pop();
                    }
                    if(stack.empty()) temp=-1;
                    else temp= stack.peek();
                    stack.push(nums2[count]);
                }
            }
            hm.put(nums2[count],temp);
            count--;
        }
        int[] ans = new int[nums1.length];
        for(int j=0; j<nums1.length; j++){
            ans[j] = hm.get(nums1[j]);
        }
        return ans;
    }
}
