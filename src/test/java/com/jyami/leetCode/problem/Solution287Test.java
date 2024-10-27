package com.jyami.leetCode.problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution287Test {

    @Test
    void findDuplicateTest() {
        int duplicate = new Solution287().findDuplicate(new int[]{1, 2, 3, 4, 4});
        System.out.println(duplicate);
    }

}
