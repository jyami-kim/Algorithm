//
//  main.cpp
//  hash_not_completion_player
//
//  Created by jyami on 2020/01/03.
//  Copyright © 2020 jyami. All rights reserved.
//  https://programmers.co.kr/learn/courses/30/lessons/42576?language=cpp
//

#include <iostream>
#include <string>
#include <vector>
#include <unordered_map>


using namespace std;

string solution(vector<string> participant, vector<string> completion);

int main() {
    // insert code here...

    std::vector<string> participant;
    participant.push_back("a");
    participant.push_back("b");
    participant.push_back("b");
    
    std::vector<string> completion;
    completion.push_back("a");
    completion.push_back("b");
    
    string a = solution(participant, completion);
    std::cout << a;
    return 0;
}

string solution(vector<string> participant, vector<string> completion) {
    
    unordered_map<string, int> map;
    
    for(auto iter : participant){
        string key = iter;
        int value = map[key];
        if(!map.count(key)){
            value = 0;
        }
        map[key] = ++value;
    }
    
    for(auto iter : completion){
        string key = iter;
        int value = map[key];
        map[key] = --value;
    }
    
    for(auto iter : map){
        if(iter.second == 1){
            return iter.first;
        }
    }
    
    return "";
}

