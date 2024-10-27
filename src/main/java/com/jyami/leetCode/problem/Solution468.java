package com.jyami.leetCode.problem;

import java.util.regex.Pattern;

/**
 * Created by jyami on 2020/06/17
 */
public class Solution468 {


    static final String chunkIPv4 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
    static final Pattern pattenIPv4 = Pattern.compile("^(" + chunkIPv4 + "\\.){3}" + chunkIPv4 + "$");

    static final String chunkIPv6 = "([0-9a-fA-F]{1,4})";
    static final Pattern pattenIPv6 = Pattern.compile("^(" + chunkIPv6 + "\\:){7}" + chunkIPv6 + "$");

    public String validIPAddress(String IP) {
        return pattenIPv4.matcher(IP).matches() ? "IPv4" :
                pattenIPv6.matcher(IP).matches() ? "IPv6" : "Neither";
    }


}
