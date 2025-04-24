class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashSet<Integer> hset = new HashSet<>();
        for(int i : nums) hset.add(i);
        return countSubarraysHelper(nums, hset.size());
    }
    private int countSubarraysHelper(int[] arr, int elements) {
        int len = arr.length;
        int count = 0;
        int l = 0;
        int r = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();// to track freq of a,b,c
        while(r<len){
            hm.put(arr[r],hm.getOrDefault(arr[r],0)+1);
            if(hm.size()==elements){ //all present, count and shrink window.
                //System.out.println(s.substring(l,r+1)+" "+ curr+" "+hash[0]+hash[1]+hash[2]+" "+count);
                while(hm.size()==elements){
                    hm.put(arr[l],hm.get(arr[l])-1);
                    if(hm.get(arr[l])==0) hm.remove(arr[l]);
                    count+=len-r;
                    l++;
                }
            }
            //System.out.println(s.substring(l,r+1)+" "+ curr+" "+hash[0]+hash[1]+hash[2]+" "+count);
            r++;
        }
        return count;
    }
}