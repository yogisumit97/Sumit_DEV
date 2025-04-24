class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return  kDistinctSubarratHelper(k, nums)- kDistinctSubarratHelper(k-1, nums);// at most k - at most(k-1);
    }
    private static int kDistinctSubarratHelper(int k,int[] nums) {
        //System.out.println();
        //System.out.println("For K =="+k+" :" );
        if(k<=0) return 0;
		HashMap<Integer,Integer> hm = new HashMap<>();//freq store
		int l = 0;
		int r = 0;
		int maxLen = 0;
		while(r<nums.length){
            int curr = nums[r];
			hm.put(curr, hm.getOrDefault(curr,0)+1);
            //System.out.println(hm+"    Size : "+ hm.size());
			if(hm.size()>k){ // shrink window
				int temp =nums[l];
				hm.put(temp, hm.get(temp)-1);
				if(hm.get(temp)==0) hm.remove(temp);
                //System.out.println("after deleting "+temp+" :"+hm);
				l = l+1;
                //System.out.println("left = "+l);
                hm.put(curr, hm.get(curr)-1);
                continue;
			}
            if(hm.size()<=k) maxLen+= r-l+1;
            //System.out.println(r-l+1);
			r++;
		}
		return maxLen;
	}
}