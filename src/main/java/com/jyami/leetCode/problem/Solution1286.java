package com.jyami.leetCode.problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by jyami on 2020/08/13
 */
public class Solution1286 {

    public static void main(String[] args) {
        CombinationIterator abc = new CombinationIterator("abc", 2);
        System.out.println(abc.next());
        System.out.println(abc.hasNext());
        System.out.println(abc.next());
        System.out.println(abc.hasNext());
        System.out.println(abc.next());
        System.out.println(abc.hasNext());
    }
}


class CombinationIterator {

    String characters;
    Queue<String> queue = new LinkedList<>();

    public CombinationIterator(String characters, int combinationLength) {
        this.characters = characters;
        for (int i = 0; i < (1 << characters.length()); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < characters.length(); j++) {
                if ((i & (1 << j)) > 0) { // 주어진 i를 한 자리씩 탐색 : i = 2(10), j = 0(1)  => 3(11) : c추가
                    sb.append(characters.charAt(i));
                }
            }
            if (sb.toString().length() == combinationLength) {
                queue.add(sb.toString());
            }
        }

    }

    public String next() {
       return queue.poll();
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }


}
