class Solution {
public:
    bool isPalindrome(string s) {
        transform(s.begin(), s.end(), s.begin(), ::tolower);
        return check(s, 0, s.length()-1);
    }
    bool check(string s, int start, int end){
        while(start<end){
            if(!isalnum(s[start])){
                start+=1;
                continue;
            }
            if(!isalnum(s[end])){
                end-=1;
                continue;
            }
            if(s[start] != s[end]) return false;
            start++;
            end--;
        }
        return true;
    }
};