package com.jyami.programmers.hash;

import java.util.*;

/**
 * Created by jyami on 2020/01/05
 * 베스트 앨범
 * https://programmers.co.kr/learn/courses/30/lessons/42579
 */
public class BestAlbum {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        String[] genres2 = {"classic", "pop", "classic"};
        int[] plays = {500, 600, 150, 800, 2500};
        int[] solution1 = solution.solution(genres2, plays);
        for(int sol : solution1){
            System.out.print(sol+" ");
        }
    }

    static class Solution {
        public int[] solution(String[] genres, int[] plays) {

            HashMap<String, List<Album>> map = new HashMap();
            for (int i = 0; i < genres.length; i++) {
                List<Album> list = map.getOrDefault(genres[i], new ArrayList<>());
                list.add(new Album(plays[i], i));
                map.put(genres[i], list);
            }

            List<List<Album>> albumsList = new ArrayList<>();
            albumsList.addAll(map.values());
            albumsList.sort(new MyCompare());

            List<Integer> solution = new ArrayList<>();

            for (List<Album> albums : albumsList) {
                albums.sort(new AlbumCompare());
                solution.add(albums.get(0).number);
                if (albums.size() != 1) {
                    solution.add(albums.get(1).number);
                }
            }

            return solution.stream().mapToInt(i->i).toArray();
        }

        class MyCompare implements Comparator<List<Album>> {
            @Override
            public int compare(List<Album> o1, List<Album> o2) {
                int sum1 = o1.stream().mapToInt(c -> c.plays).sum();
                int sum2 = o2.stream().mapToInt(c -> c.plays).sum();

                return Integer.compare(sum2, sum1);
            }
        }

        class AlbumCompare implements Comparator<Album> {
            @Override
            public int compare(Album o1, Album o2) {
                return o1.plays < o2.plays ? 1 : o1.plays > o2.plays ? -1 :
                        o1.number > o2.number ? 1 : o1. number < o2.number ? -1 : 0;
            }
        }

        class Album {
            int plays;
            int number;

            Album(int plays, int number) {
                this.plays = plays;
                this.number = number;
            }
        }
    }
}
