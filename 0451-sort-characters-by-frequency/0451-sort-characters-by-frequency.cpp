class Solution {
public:
    string frequencySort(string s) {
        map<char, int> hm;
        for(char ch : s) hm[ch]++;
        vector<pair<char,int>> vec;
        for(auto it : hm){
            vec.push_back(pair(it.first, it.second));
        }    
        // sort vector
        sort(vec.begin(), vec.end(), [](auto& a, auto& b){
            return a.second > b.second;
        });
        string str;
        for(auto it : vec){
            for(int i =0; i<it.second; i++) str+=it.first;
        }
        return str;
    }
};