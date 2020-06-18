package com.jyami.leetCode.weekly;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Pattern;

/**
 * Created by jyami on 2020/06/17
 */
public class Solution0616 {


    static final String chunkIPv4 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
    static final Pattern pattenIPv4 = Pattern.compile("^(" + chunkIPv4 + "\\.){3}" + chunkIPv4 + "$");

    static final String chunkIPv6 = "([0-9a-fA-F]{1,4})";
    static final Pattern pattenIPv6 = Pattern.compile("^(" + chunkIPv6 + "\\:){7}" + chunkIPv6 + "$");

    public String validIPAddress(String IP) {
        return pattenIPv4.matcher(IP).matches() ? "IPv4" :
                pattenIPv6.matcher(IP).matches() ? "IPv6" : "Neither";
    }


    @ParameterizedTest()
    @ValueSource(strings = {"172.16.254.1", "172.16.254.01", "20EE:Fb8:85a3:0:0:8A2E:0370:7334",
            "2001:0db8:85a3:0:0:8A2E:0370:7334:", "2001:0db8:85a3:0000:0000:8a2e:0370:7334", "2001:db8:85a3:0:0:8A2E:0370:7334",
            "2001:0db8:85a3::8A2E:0370:7334", "02001:0db8:85a3:0000:0000:8a2e:0370:7334"})
    void validIPAddressTest(String ip) {
        System.out.println(validIPAddress(ip));
    }

}
