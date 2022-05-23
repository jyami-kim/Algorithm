from itertools import combinations
from typing import List

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []
        result.append([])
        for i in range(1, len(nums)+1):
            for j in list(combinations(nums, i)):
                result.append(list(j))
        return result

print(Solution().subsets([1,2,3]))