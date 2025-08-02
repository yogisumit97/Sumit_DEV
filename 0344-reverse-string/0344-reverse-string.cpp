class Solution {
public:
    void reverseString(vector<char>& s) {
        return reverse(s, 1);
    }
    void reverse(vector<char>& s, int num){
        if(num>s.size()) return;
        char ch = s[num-1];
        reverse(s,num+1);
        s[s.size()-num] = ch;
    }
};