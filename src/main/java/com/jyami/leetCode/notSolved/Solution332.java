package com.jyami.leetCode.notSolved;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jyami on 2020/06/28
 */
public class Solution332 {
    public List<String> findItinerary(List<List<String>> tickets) {

        List<List<String>> list = findList(tickets);
        String last = list.get(list.size() - 1).get(1);

        List<String> collect = list.stream()
                .map(c -> c.get(0))
                .collect(Collectors.toList());
        collect.add(last);

        return collect;
    }

    public List<List<String>> findList(List<List<String>> tickets) {
        if (tickets.isEmpty()) {
            return null;
        }

        List<List<String>> retain = new ArrayList<>();
        LinkedList<List<String>> mainList = new LinkedList<>();

        mainList.add(tickets.get(0));

        for (int i = 1; i < tickets.size(); i++) {
            boolean addSub = true;
            for (int j = 0; j < mainList.size(); j++) {
                if (mainList.get(j).get(1).equals(tickets.get(i).get(0))) {
                    mainList.add(j + 1, tickets.get(i));
                    addSub = false;
                    break;
                } else if (mainList.get(j).get(0).equals(tickets.get(i).get(1))) {
                    mainList.add(j, tickets.get(i));
                    addSub = false;
                    break;
                }
            }
            if (addSub) {
                retain.add(tickets.get(i));
            }
        }

        List<List<String>> itinerary = findList(retain);
        if (itinerary != null) {
            int size = itinerary.size();
            for (int i = 0; i < mainList.size()-1; i++) {
                if (itinerary.get(0).get(0).equals(mainList.get(i).get(1)) &&
                        itinerary.get(size - 1).get(1).equals(mainList.get(i + 1).get(0))) {
                    mainList.addAll(i + 1, itinerary);
                    return mainList;
                }
            }
            if (itinerary.get(0).get(0).equals(mainList.getLast().get(1))) {
                mainList.addAll(mainList.size(), itinerary);
            } else {
                mainList.addAll(0, itinerary);
            }
        }

        return mainList;
    }

    @Test
    void findItineraryTest() {
        List<List<String>> input = Arrays.asList(
                Arrays.asList("JFK", "ATL"),
                Arrays.asList("ORD", "PHL"),
                Arrays.asList("JFK", "ORD"),
                Arrays.asList("PHX", "LAX"),
                Arrays.asList("LAX", "JFK"),
                Arrays.asList("PHL", "ATL"),
                Arrays.asList("ATL", "PHX"));

        //["JFK","ATL","PHX","LAX","JFK","ORD","PHL","ATL"]


//        List<List<String>> input = Arrays.asList(
//                Arrays.asList("JFK", "SFO"),
//                Arrays.asList("JFK", "ATL"),
//                Arrays.asList("SFO", "ATL"),
//                Arrays.asList("ATL", "JFK"),
//                Arrays.asList("ATL", "SFO"));

        //["JFK","ATL","JFK","SFO","ATL","SFO"]

//        List<List<String>> input = Arrays.asList(
//                Arrays.asList("MUC", "LHR"),
//                Arrays.asList("JFK", "MUC"),
//                Arrays.asList("SFO", "SJC"),
//                Arrays.asList("LHR", "SFO"));
        // ["JFK", "MUC", "LHR", "SFO", "SJC"]

        System.out.println(findItinerary(input));
    }
}
