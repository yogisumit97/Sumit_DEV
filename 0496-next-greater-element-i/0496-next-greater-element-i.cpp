class Solution {
public:
    vector<int> nextGreaterElement(vector<int>& nums1, vector<int>& nums2) {
        int len = nums2.size();
        map<int,int> nge;
        vector<int> ans(nums1.size(), 0);
        stack<int> st;
        nge[nums2[len-1]] = -1;
        st.push(nums2[len-1]);
        for(int i = len-2; i>=0; i--){
            if(st.top() > nums2[i]){
                nge[nums2[i]] = st.top();
                st.push(nums2[i]);
            }
            else{
                while(!st.empty() && st.top()< nums2[i]){
                    st.pop();
                }
                if(st.empty()) nge[nums2[i]] = -1;
                else nge[nums2[i]] = st.top();

                st.push(nums2[i]);
            }
        }
        for(int i=0; i<nums1.size(); i++){
            ans[i] = nge[nums1[i]];
        }
        return ans;
    }
};