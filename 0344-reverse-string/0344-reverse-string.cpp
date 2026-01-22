class Solution {
public:
    void reverseString(vector<char>& vec) {
        int i =0;
        int j = vec.size()-1;
        while(i<j){
            char temp = vec[i];
            vec[i] = vec[j];
            vec[j] = temp;
            i++;j--;
        }    
    }
};