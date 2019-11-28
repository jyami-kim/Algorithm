//
// Created by mor22 on 2019-11-29.
//

#include <cstdio>
#include "stdio.h"


class Solution {
public:
    int hello(int a) {
        bool first = true;
        int result = 0;
        while (a != 0) {
            int digit = a % 10;
            if (first) {
                result = digit;
                first = false;
            } else {
                result = result * 10;
                result += digit;
            }
            a = a / 10;
        }
        return result;
    }
};

int main() {
    Solution solution = Solution();
    int a = solution.hello(1234);
    printf("%d", a);
}
