package com.jyami.leetCode.problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class Solution468Test {

    @ParameterizedTest()
    @ValueSource(strings = {"172.16.254.1", "172.16.254.01", "20EE:Fb8:85a3:0:0:8A2E:0370:7334",
        "2001:0db8:85a3:0:0:8A2E:0370:7334:", "2001:0db8:85a3:0000:0000:8a2e:0370:7334", "2001:db8:85a3:0:0:8A2E:0370:7334",
        "2001:0db8:85a3::8A2E:0370:7334", "02001:0db8:85a3:0000:0000:8a2e:0370:7334"})
    void validIPAddressTest(String ip) {
        System.out.println(new Solution468().validIPAddress(ip));
    }

}
