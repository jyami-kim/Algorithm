package com.jyami.exam.programmers;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class KakaoIntern2 {
    public static void main(String args[]) {
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        Solution solution = new Solution();
        int[] solution1 = solution.solution(s);
        for(int i : solution1){
            System.out.println(i);
        }
    }

    static class Solution {
        public int[] solution(String s) {

            Map<Integer, List<Integer>> map = new HashMap<>();
            // parsing

            List<String> strings = parsingBig(s);

            int maxSize = 0;

            for (String str : strings) {
                List<Integer> integers = parsingSmall(str);
                int size = integers.size();
                if (size > maxSize) {
                    maxSize = size;
                }
                map.put(size, integers);
            }

            List<Integer> resultArr = new ArrayList<>();

            for (int i = 1; i <= maxSize; i++) {
                List<Integer> getMapList = map.get(i);
                getMapList.removeAll(resultArr);
                Integer integer = getMapList.get(0);
                resultArr.add(integer);

            }

            int[] result = new int[maxSize];
            for (int i = 0; i < maxSize; i++) result[i] = resultArr.get(i);
            return result;
        }

        private List<String> parsingBig(String input) {
            String string = input.replaceFirst("\\{", "");
            Pattern infoPattern = Pattern.compile("\\{().*?\\}");
            Matcher infoMatcher = infoPattern.matcher(string);

            List<String> strings = new ArrayList<>();
            while (infoMatcher.find()) {
                strings.add(infoMatcher.group());
            }
            return strings;
        }

        private List<Integer> parsingSmall(String input) {
            String string = input.replaceAll("\\{|\\}", "");
            String[] tuples = string.split(",");
            return Arrays.asList(tuples).stream()
                    .map(Integer::new)
                    .collect(Collectors.toList());
        }

    }


}
