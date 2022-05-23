//
//  main.cpp
//  finding_prime_number
//
//  Created by jyami on 2020/01/05.
//  Copyright © 2020 jyami. All rights reserved.
//  https://programmers.co.kr/learn/courses/30/lessons/42839?language=cpp
//

#include <vector>
#include <stdio.h>
#include <algorithm>
#include <string>
#include <unordered_set>

using namespace std;


void combination(vector<int> nums, int r, vector<string> *result);
void multi(string str, unordered_set<int> *result);
vector<bool> primArray(unordered_set<int> *set);
int solution(string numbers);

int main() {
    string numbers = "110";
    int result = solution(numbers);
    printf("%d", result);
}



void multi(string str, unordered_set<int> *result){
    vector<int> nums;
    for(int i =0; i<str.length(); i++){
        nums.push_back(str[i] - '0');
    }
    sort(nums.begin(), nums.end());
    
    do{
        int num = 0;
        for(int i=0; i<nums.size(); i++){
            num = num * 10 + nums[i];
        }
        result->insert(num);
    }while(next_permutation(nums.begin(), nums.end()));
}


void combination(vector<int> nums, int r, vector<string> *result){
    string answer = "";
    vector<int> sub(nums.size());
    fill(sub.end()-r, sub.end(), true);
    do{
        for(int i = 0; i<nums.size();i++){
            if(sub[i]){
                answer += to_string(nums[i]);
            }
        }
        result->push_back(answer);
    }while(next_permutation(sub.begin(), sub.end()));
}

int solution(string numbers) {
    vector<int> nums;
    
    for(int i =0; i<numbers.length(); i++){
        nums.push_back(numbers[i] - '0');
    }
    sort(nums.begin(), nums.end());
    
    // 조합 생성
    vector<string> quest;
    for(int r = 1; r<=numbers.length(); r++){
        combination(nums, r, &quest);
    }
    
    // 조합안에서 순서 바꾸기 생성
    unordered_set<int> set;
    for(int i =0; i< quest.size() ;i++){
        multi(quest.at(i), &set);
    }
    
    vector<bool> array = primArray(&set);
    
    int count = 0;
    for(int a : set){
        if(!array[a]){
            count++;
        }
    }
    
    return count;
}

vector<bool> primArray(unordered_set<int> *set){
    int max = -1;
    for(int i : *set){
        if(max < i){
            max = i;
        }
    }
    
    vector<bool> array(max+1);
    array.assign(0, true); // false이면 소수임
    
    int i = 2;
    while(i <= max){
        int index = i + i;
        if(!array[i]){
            while(index <= max){
                array[index] = true;
                index = index + i;
            }
        }
        i++;
    }
    
    return array;
}

