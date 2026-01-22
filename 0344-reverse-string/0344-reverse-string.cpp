class Solution {
public:
    void reverseString(vector<char>& vec) {
        auto its = vec.begin();
        auto ite = vec.end()-1;
        while(its < ite){
            char temp = *its;
            *its = *ite;
            *ite = temp;
            its++;
            ite--;
        }    
    }
};