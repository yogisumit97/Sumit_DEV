class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int, vector<int>, greater<int>> pq;
        for(int i=0; i<k; i++) pq.push(-10001);
        for(int num : nums){
            if(num > pq.top()){
                pq.pop();
                pq.push(num);
            }
        }
        return pq.top();
    }
};