package com.jyami.leetCode.problem;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Created by jyami on 2020/08/11
 */
public class Solution274 {

    // 어느 과학자가 h개의 논문이 h번 이상 인용되고 나머지 논문들은 h번 미만 인용되었다면, 그 과학자의 h-index는 h이다.
    // https://m.blog.naver.com/PostView.nhn?blogId=analdong&logNo=140127150175&proxyReferer=https:%2F%2Fwww.google.com%2FLeetcode: 0810 challenge

    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        int h = 0;
        int i;
        for (i = citations.length - 1; i >= 0; i--) {
            if (h >= citations[i])
                break;
            h++;
        }

        return h;
    }

    @Test
    void hIndexTest(){
        int[] citations = {47,42,37,36,21,18,17,16,16,16,15,13,13,13,13,12,12,12,12,11};
        int i = hIndex(citations);
        System.out.println(i);
    }
}
